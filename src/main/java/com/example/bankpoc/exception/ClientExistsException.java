package com.example.bankpoc.exception;

public class ClientExistsException extends RuntimeException{

    public ClientExistsException(String name, String cpf) {
        super("Cliente: " + name + ", CPF: " + cpf + " ja cadastrado!!");
    }
}
