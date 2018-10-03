package com.example.bankpoc.exception.tranfer;

public class DepositEqualsRecipientException extends RuntimeException {

    public DepositEqualsRecipientException() {
        super("Depositante igual ao Beneficiário");
    }
}
