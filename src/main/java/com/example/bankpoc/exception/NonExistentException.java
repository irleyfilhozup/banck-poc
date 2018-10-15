package com.example.bankpoc.exception;

public class NonExistentException extends RuntimeException {

    private String field;
    private String error;

    public NonExistentException(String error, String response, String field) {
        super(response);
        this.field = field;
        this.error = error;
    }

    public NonExistentException(String error, String response) {
        super(response);
        this.error = error;
    }

    public NonExistentException(String response) {
        super(response);
    }

    public String getField() {
        return this.field;
    }

    public String getError() {
        return error;
    }
}
