package com.example.bankpoc.exception;

@SuppressWarnings("serial")
public class InvalidValueException extends RuntimeException {

	public InvalidValueException(double value) {
		super("Valor inválido: " + value);		
	}
}
