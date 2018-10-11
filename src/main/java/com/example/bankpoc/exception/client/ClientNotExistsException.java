package com.example.bankpoc.exception.client;

public class ClientNotExistsException extends RuntimeException {

    public ClientNotExistsException() {
        super("Cliente: não existe no banco de dados");
    }
}
