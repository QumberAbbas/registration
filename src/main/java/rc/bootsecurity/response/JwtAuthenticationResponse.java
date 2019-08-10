package rc.bootsecurity.response;

import java.io.Serializable;

/**
 * @author Qumber Abbas
 */

public class JwtAuthenticationResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}