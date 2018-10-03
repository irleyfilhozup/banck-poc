package com.example.bankpoc.exception.client;

public class ClientNotExistsException extends RuntimeException {

    public ClientNotExistsException(String name, String cpf) {
        super("Cliente: " + name + ", CPF: " + cpf + " não existe no banco de dados!!");
    }

    public ClientNotExistsException() {
        super("Cliente: não existe no banco de dados!!");
    }
}
