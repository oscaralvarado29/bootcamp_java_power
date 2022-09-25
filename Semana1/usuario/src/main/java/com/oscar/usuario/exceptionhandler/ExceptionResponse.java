package com.oscar.usuario.exceptionhandler;

public enum ExceptionResponse {
    USER_ALREADY_EXISTS("User already exists"),
    EMAIL_NOT_PRESENT("Email not present"),
    EMAIL_INVALID_FORMAT("Email invalid format"),
    MISSING_MANDATORY_DATA("Missing mandatory data"),
    USER_NOT_FOUND("User not found"),
    PASSWORD_NOT_VALID("Password not valid");


    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
