package com.example.bankpoc.service;

import java.util.Collection;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Transfer;

public interface TransferService {

    Transfer deposit(Account account, double value);

    Transfer transferBank(Account accountDeposit, Account accountRecipient, double value);

    Transfer cashOut(Account account, double value);

    String getBalance(int idClient);

    Collection<Transfer> getTransfers(Integer id);
}
