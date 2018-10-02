package com.example.bankpoc.service;

import java.util.Collection;

import com.example.bankpoc.models.Transfer;

public interface TransferService {

    Transfer deposit(int idRecipient, double value);

    Transfer transferBank(int idRecipient, int idDepositor, double value);

    Transfer cashOut(int idClient, double value);

    String getBalance(int idClient);

    Collection<Transfer> getTransfers(Integer id);
}
