package com.example.bankpoc.service;

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

        accountService.update(accountRecipient, clientRecipient.getId_account());

        transferRepository.save(transfer);

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
}
