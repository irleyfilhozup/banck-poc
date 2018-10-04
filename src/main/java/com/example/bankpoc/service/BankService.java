package com.example.bankpoc.service;

import java.util.Collection;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyDepositCashOut;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.Transfer;

public interface BankService {


    Collection<Client> findAllClient();

    Client findById(Integer id);

    Client createClient(Client newClient);

    Client updateClient(Client clientUpDate, Integer id);

    Transfer deposit(ObjBodyDepositCashOut objBody);

    Transfer transferBank(ObjBodyTransfer objBodyTransfer);

    Transfer cashOut(ObjBodyDepositCashOut objBody);

    String getBalance(int idClient);

    boolean deleteClient(int id);

    Collection<Transfer> getTransfers(Integer id);
}
