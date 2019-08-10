package rc.bootsecurity.model;

public class BooleanResponse {

    private static final String successMessage = "Operation Successful";
    private static final String failureMessage = "Operation Failed";

    private boolean success;
    private String message;

    public BooleanResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static BooleanResponse success(){
        return new BooleanResponse(true, successMessage);
    }

    public static BooleanResponse failure(){
        return new BooleanResponse(false, failureMessage);
    }

    public static BooleanResponse of(boolean success){
        return success ? success() : failure();
    }


}
