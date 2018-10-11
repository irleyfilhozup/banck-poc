package com.example.bankpoc.exception;

import java.util.List;
import java.util.LinkedList;


public class BusinessException extends RuntimeException {

    private String field;

    public BusinessException(String response, String field) {
        super(response);
        this.field = field;
    }

    public BusinessException(String response) {
        super(response);
    }


    public String getField() {
        return this.field;
    }
}
