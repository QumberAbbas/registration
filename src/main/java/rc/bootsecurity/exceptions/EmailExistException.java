package rc.bootsecurity.exceptions;

public class EmailExistException extends GlobalException {
    public EmailExistException(String errorCode, String message) {
        super(errorCode, message);
    }
}