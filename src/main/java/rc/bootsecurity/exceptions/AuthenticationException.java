package rc.bootsecurity.exceptions;

public class AuthenticationException extends GlobalException {
    public AuthenticationException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}