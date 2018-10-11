package com.example.bankpoc.interceptor;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBuilder {

    private String field;
    private String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBuilder{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
