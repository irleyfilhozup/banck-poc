package com.example.bankpoc.ValidateTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.validation.ValidateTransactionValue;


@RunWith(SpringRunner.class)
public class ValidateTransactionValueTest {

    private ValidateTransactionValue validateTransactionValue = new ValidateTransactionValue();
    private double value;


    @Test
    public void checkCashOutTest_ValueValid() {

        value = 200;
        try{
            validateTransactionValue.checkCashOut(value);
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void checkCashOutTest_ValueInvalid() {

        value = -200;
        try{
            validateTransactionValue.checkCashOut(value);
        }
        catch (RuntimeException error) {
            assertEquals("Valor inválido: " + value,error.getMessage());
        }
    }

    @Test
    public void checkDeposit_ValueValid() {

        value = 200;
        try{
            validateTransactionValue.checkDeposit(value);
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void checkDeposit_ValueInvalid() {

        value = -200;
        try{
            validateTransactionValue.checkDeposit(value);
        }
        catch (RuntimeException error) {
            assertEquals("Valor inválido: " + value,error.getMessage());
        }
    }
}
