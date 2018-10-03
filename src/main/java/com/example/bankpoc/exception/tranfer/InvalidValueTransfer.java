package com.example.bankpoc.exception.tranfer;

public class InvalidValueTransfer extends RuntimeException {

    public InvalidValueTransfer(double balance) {
        super("O valor R$ " + balance + " é inválido!");
    }
}
