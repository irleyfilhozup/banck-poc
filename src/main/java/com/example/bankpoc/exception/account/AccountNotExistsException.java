package com.example.bankpoc.exception.account;

public class AccountNotExistsException extends RuntimeException {

    public AccountNotExistsException() {
        super("A conta informada não foi encontrada no banco de dados");
    }

}
