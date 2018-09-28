package com.example.bankpoc.exception;

public class UnfilledFieldsException extends RuntimeException {

    public UnfilledFieldsException() {
        super("Campos não preenchidos");
    }
}
