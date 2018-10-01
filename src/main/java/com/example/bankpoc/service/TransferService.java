package com.example.bankpoc.service;

import com.example.bankpoc.models.Transfer;

public interface TransferService {

    Transfer deposit(int idRecipient, double value);

    Transfer transferBank(int idRecipient, int idDepositor, double value);
}
