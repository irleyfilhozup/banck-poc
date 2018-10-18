package com.example.bankpoc.interceptor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.bankpoc.exception.BusinessException;

public class ControllerExceptionHandlerTest {

    private BusinessException exception;
    ControllerExceptionHandler controllerExceptionHandler;

    @Before
    public void setUp() throws Exception {
        exception = new BusinessException("Titulo","mensagem","campo");
        controllerExceptionHandler = new ControllerExceptionHandler();
    }

    @Test
    public void processValidationErrorInternTest_Ok() {
        MessageBuilder messageBuilder = controllerExceptionHandler.processValidationErrorIntern(exception);
        assertEquals("Titulo", messageBuilder.getTitle());
        assertEquals("mensagem", messageBuilder.getMessage());
        assertEquals("campo", messageBuilder.getField());

    }
}