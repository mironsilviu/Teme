package service.exception;

import lombok.Getter;

public enum ValidationExceptionMessage {


    NO_EMPLOYEE(001, "Set employee first"),
    NAME_TOO_SHORT(002, "Name is too short"),
    INVALID_PASSWORD(003, "Invalid password"),
    NO_CLIENT(001, "Set client first"),
    NO_ROOM(001, "Create room first"),
    NR_OF_ROOM(002, "Shoud enter at least one room"),
    WRONG_TYPE(003, "Wrong room type");
    @Getter
    private int code;
    @Getter
    private String message;

    ValidationExceptionMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
