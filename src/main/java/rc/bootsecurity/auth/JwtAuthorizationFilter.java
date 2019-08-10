package rc.bootsecurity.auth;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtAuthorizationFilter(@Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.debug("processing authentication for '{}'", request.getRequestURL());

        // Read the Authorization header, where the JWT token should be
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        // If header does not contain BEARER or is null delegate to Spring impl and exit
        if (doesHeaderIncludeJwtToken(header)) {
            logger.warn("couldn't find bearer string, will ignore the header");
            chain.doFilter(request, response);
            return;
        }

        // If header is present, try grab user principal from database and perform authorization
        Authentication authentication = getUsernamePasswordAuthentication(request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue filter execution
        chain.doFilter(request, response);
    }

    private boolean doesHeaderIncludeJwtToken(String header) {
        return header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String token = jwtTokenUtil.getTokenFromRequestHeader(request);

        String userName = getUserNameFromToken(token);


        if (needToAuthorizeUser(userName)) {

            logger.debug("security context was null, so authorizing user");

            UserDetails userDetails = getUserDetails(userName, response);

            if (jwtTokenUtil.validateToken(token, userDetails)) {
                return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            }
        }

        return null;
    }

    private UserDetails getUserDetails(String userName, HttpServletResponse response) throws IOException {
        try {
            return userDetailsService.loadUserByUsername(userName);
        } catch (UsernameNotFoundException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return null;
        }

    }

    private boolean needToAuthorizeUser(String userName) {
        return userName != null && SecurityContextHolder.getContext().getAuthentication() == null;
    }

    private String getUserNameFromToken(String token) {
        try {
            return jwtTokenUtil.getUserNameFromToken(token);
        } catch (IllegalArgumentException e) {
            logger.error("an error occurred during getting username from token", e);
        } catch (ExpiredJwtException e) {
            logger.warn("the token is expired and not valid anymore", e);
        }
        return null;
    }
}
