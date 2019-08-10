package rc.bootsecurity.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import rc.bootsecurity.auth.IAuthenticationFacade;

import java.util.Optional;

/**
 * @author qumberabbas
 */
public class  AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private IAuthenticationFacade iAuthenticationFacade;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(getUserName(iAuthenticationFacade.getAuthentication()));
    }

    private String getUserName(Authentication authentication) {
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
           return authentication.getName();
        }
        return "";
    }
}