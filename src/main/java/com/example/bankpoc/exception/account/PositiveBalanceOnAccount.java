package com.example.bankpoc.exception.account;

public class PositiveBalanceOnAccount extends RuntimeException {

    public PositiveBalanceOnAccount(double balance) {
        super("Impossivel deletar cliente, saldo em conta no valor R$ " + balance + ".");
    }
}
