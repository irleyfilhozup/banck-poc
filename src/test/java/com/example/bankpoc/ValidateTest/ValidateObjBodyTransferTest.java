package com.example.bankpoc.ValidateTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.validation.ValidateObjBodyTransfer;

@RunWith(SpringRunner.class)
public class ValidateObjBodyTransferTest {

    private ValidateObjBodyTransfer validateObjBodyTransfer = new ValidateObjBodyTransfer();

    private ObjBodyTransfer objBodyTransfer;

    @Before
    public void setUp() throws Exception {
        objBodyTransfer = new ObjBodyTransfer(1,2,200);
    }

    @Test
    public void checkTest_Valid() {

        validateObjBodyTransfer.check(objBodyTransfer);
    }

    @Test
    public void checkTest_Invalid() {

        ObjBodyTransfer objBodyTransfer1 = new ObjBodyTransfer();
        try {
            validateObjBodyTransfer.check(objBodyTransfer1);
        }
        catch (RuntimeException error) {
            assertEquals("Campos não preenchidos", error.getMessage());
        }

    }

    @Test
    public void validValueTest_Valid() {

        validateObjBodyTransfer.validValue(200);
    }

    @Test
    public void validValueTest_Invalid() {

        double value = -200;
        try {
            validateObjBodyTransfer.validValue(value);
        }
        catch (RuntimeException error) {
            assertEquals("Valor inválido: " + value, error.getMessage());
        }
    }
}
