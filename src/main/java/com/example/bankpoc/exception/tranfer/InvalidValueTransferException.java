package com.example.bankpoc.exception.tranfer;

public class InvalidValueTransferException extends RuntimeException {

    public InvalidValueTransferException(double balance) {
        super("O valor R$ " + balance + " é inválido!");
    }
}
