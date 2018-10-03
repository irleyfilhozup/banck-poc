package com.example.bankpoc.service;

import java.util.Collection;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyDepositCashOut;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.Transfer;

public interface BankService {

    Collection<Account> findAllAccount();

    Account findOneAccount(int id);

    Account createAccount(Account newAccount);

    Account updateAccount(Account accountUpDate, Integer id);

    void deleteAccount(int id);


    Collection<Client> findAllClient();

    Client findOneClient(int id);

    Client createClient(Client newClient);

    Client updateClient(Client clientUpDate, Integer id);

   // boolean deleteClient(int id);


    Transfer deposit(ObjBodyDepositCashOut objBody);

    Transfer transferBank(ObjBodyTransfer objBodyTransfer);

    Transfer cashOut(ObjBodyDepositCashOut objBody);

    String getBalance(int idClient);

    Collection<Transfer> getTransfers(Integer id);
}
