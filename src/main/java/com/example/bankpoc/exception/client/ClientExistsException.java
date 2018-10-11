package com.example.bankpoc.exception.client;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ClientExistsException extends RuntimeException{

    public ClientExistsException() {
        super("O cliente já tem cadastro no banco de dados");
    }
}
