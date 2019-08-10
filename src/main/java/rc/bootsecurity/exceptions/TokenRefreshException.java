package rc.bootsecurity.exceptions;

public class TokenRefreshException extends GlobalException {
    public TokenRefreshException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}