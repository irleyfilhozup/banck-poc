package com.example.bankpoc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.TransactionsBank;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.repository.TransferRepository;


@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class TransferServiceBean implements TransferService {

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @Autowired
    private TransferRepository transferRepository;

    TransactionsBank transactionsBank = new TransactionsBank();

    @Override
    public Transfer deposit(int idRecipient, double value) {

        Client clientRecipient = clientService.findOne(idRecipient);
        Account accountRecipient = accountService.findOne(clientRecipient.getId_account());

        Transfer transfer = transactionsBank.deposit(accountRecipient, value);
        transferRepository.save(transfer);

        accountService.update(accountRecipient, clientRecipient.getId_account());

        return transfer;
    }

    @Override
    public Transfer transferBank(int idRecipient, int idDeposit, double value) {

        Client clientDeposit = clientService.findOne(idDeposit);
        Client clientRecipient = clientService.findOne(idRecipient);

        Account accountDeposit = accountService.findOne(clientDeposit.getId_account());
        Account accountRecipient = accountService.findOne(clientRecipient.getId_account());

        Transfer transfer = transactionsBank.transfer(accountRecipient, accountDeposit, value);
        transferRepository.save(transfer);

        accountService.update(accountRecipient, clientRecipient.getId_account());
        accountService.update(accountDeposit, clientDeposit.getId_account());

        return transfer;
    }

    @Override
    public Transfer cashOut(int idClient, double value) {

        Client client = clientService.findOne(idClient);
        Account account = accountService.findOne(client.getId_account());

        Transfer transfer = transactionsBank.cashOut(account, value);
        transferRepository.save(transfer);

        accountService.update(account, client.getId_account());

        return transfer;
    }

    @Override
    public String getBalance(int idClient) {

        Client client = clientService.findOne(idClient);
        Account account = accountService.findOne(client.getId_account());

        String balance = transactionsBank.getBalance(account);


        return balance;
    }

    @Override
    public Collection<Transfer> getTransfers(Integer id) {
        Client client = clientService.findOne(id);
        Account account = accountService.findOne(client.getId_account());
        Collection<Transfer> transfers = transferRepository.findByTransactionWithId(account.getId());
        return transfers;
    }


}
