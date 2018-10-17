package com.example.bankpoc.util;

import com.example.bankpoc.exception.BusinessException;

public class ValidCPF {

    public static void check(String cpfNumber) {
        if (!isCPFValid(cleanCPF(cpfNumber))) {
            throw new BusinessException("cpf","CPF Invalido");
        }
    }

    private static String cleanCPF(String cpf) {
        return cpf.trim().replace(" ", "").replace(",", "")
                .replace(".", "").replace("-", "");
    }

    private static boolean isCPFValid(final String CPF) {
        if (verifiesIfCpfHasElevenDigits(CPF))
            return false;

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            num = CPF.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char) (r + 48);
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = CPF.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        dig11 = ((r == 10) || (r == 11)) ? '0' : (char) (r + 48);
        return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
    }

    private static boolean verifiesIfCpfHasElevenDigits(String cpf) {
        return (cpf.length() != 11);
    }
}
