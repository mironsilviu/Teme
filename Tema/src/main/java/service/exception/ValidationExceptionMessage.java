package service.exception;

public enum ValidationExceptionMessage {


    NO_EMPLOYEE(001, "Set employee first"),
    NAME_TOO_SHORT(002, "Name is too short"),
    INVALID_PASSWORD(003, "Invalid password"),
    NO_CLIENT(001, "Set client first");

    private int code;
    private String message;

    ValidationExceptionMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
