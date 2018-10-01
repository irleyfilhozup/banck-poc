package com.example.bankpoc.models;

import java.sql.Timestamp;

public class TransactionsBank {

    public Transfer transfer(Account clientRecipient, Account clientDeposit, double value) {

        clientRecipient.deposit(value);
        clientDeposit.toWithdraw(value);
        Transfer transfer = new Transfer(clientRecipient.getId(),
                clientDeposit.getId(),
                value,
                new Timestamp(System.currentTimeMillis()));

        return transfer;
    }

    public Transfer deposit(Account clientRecipient, double value) {

        clientRecipient.deposit(value);
        Transfer transfer = new Transfer(clientRecipient.getId(),
                value,
                new Timestamp(System.currentTimeMillis()));

        return transfer;
    }
}
