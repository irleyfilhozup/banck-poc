package com.example.bankpoc.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.bankpoc.exception.BusinessException;

public class ValidCPFTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void check_whenCpfIsValidItShouldNotThrowException() {
        //dado que
        String cpf = "32653746026";
        //quando
        ValidCPF.check(cpf);
        //entao
    }

    @Test
    public void check_WhenYouHaveLetterInCpfItShouldThrowException() {
        //dado que
        String cpf = "3265374626s";
        thrown.expect(BusinessException.class);
        thrown.expectMessage("CPF Invalido");
        //quando
        ValidCPF.check(cpf);

    }

    @Test
    public void check_WhenTheCpfHasElevenDigitsButIsInvalidItShouldThrowAnException() {
        //dado que
        String cpf = "33322211122";
        thrown.expect(BusinessException.class);
        thrown.expectMessage("CPF Invalido");
        //quando
        ValidCPF.check(cpf);
    }

    @Test
    public void check_WhenTheCpfIsLessThanElevenDigitsShouldThrowAnException() {
        //dado que
        String cpf = "3332";
        thrown.expect(BusinessException.class);
        thrown.expectMessage("CPF Invalido");
        //quando
        ValidCPF.check(cpf);
    }

    @Test
    public void check_WhenTheCpfHasMoreThanElevenDigitsItShouldThrowAnException() {
        //dado que
        String cpf = "326537460262";
        thrown.expect(BusinessException.class);
        thrown.expectMessage("CPF Invalido");
        //quando
        ValidCPF.check(cpf);
    }
}