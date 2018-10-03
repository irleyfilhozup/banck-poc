package com.example.bankpoc.exception.account;

public class NegativeBalanceOnAccount extends RuntimeException {

    public NegativeBalanceOnAccount(double balance) {
        super("Impossivel deletar cliente, com saldo negativo em conta no valor R$ " + balance + ".");
    }
}
