package service.exception;

public class ValidationException extends Exception {

    ValidationExceptionMessage validationExceptionMessage;

    public ValidationException(ValidationExceptionMessage validationExceptionMessage) {
        this.validationExceptionMessage = validationExceptionMessage;
    }

    public String displayError() {
        return "An error has occured with the code : " + validationExceptionMessage.getCode() +
                " with the message :" + validationExceptionMessage.getMessage();
    }

}
