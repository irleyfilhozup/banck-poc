package com.example.bankpoc.models;

import java.sql.Timestamp;

public class TransactionsBank {

    public Transfer transfer(Account clientRecipient, Account clientDeposit, double value) {

        clientRecipient.deposit(value);
        clientDeposit.cashOut(value);
        Transfer transfer = new Transfer(clientRecipient.getId(),
                clientDeposit.getId(),
                value,
                new Timestamp(System.currentTimeMillis()), TypeTransfer.TRANSFER);

        return transfer;
    }

    public Transfer deposit(Account clientRecipient, double value) {

        clientRecipient.deposit(value);
        Transfer transfer = new Transfer(clientRecipient.getId(),
                value,
                new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);

        return transfer;
    }

    public Transfer cashOut(Account accountClient, double value) {

        accountClient.cashOut(value);
        Transfer transfer = new Transfer(accountClient.getId(),
                value,
                new Timestamp(System.currentTimeMillis()),TypeTransfer.CASHOUT);

        return transfer;
    }

    public String getBalance(Account account) {

        return String.valueOf(account.getBalance());

    }
}
