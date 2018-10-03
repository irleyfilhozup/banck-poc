package com.example.bankpoc.exception.client;

public class UnfilledFieldsException extends RuntimeException {

    public UnfilledFieldsException() {
        super("Campos não preenchidos");
    }
}
