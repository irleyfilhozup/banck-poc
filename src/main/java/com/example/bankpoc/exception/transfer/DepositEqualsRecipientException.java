package com.example.bankpoc.exception.transfer;

public class DepositEqualsRecipientException extends RuntimeException {

    public DepositEqualsRecipientException() {
        super("Depositante igual ao Beneficiário");
    }
}
