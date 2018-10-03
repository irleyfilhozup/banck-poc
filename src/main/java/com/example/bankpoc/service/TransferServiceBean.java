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
    public Transfer deposit(Account account, double value) {

        Transfer transfer = transactionsBank.deposit(account, value);
        transferRepository.save(transfer);
        return transfer;
    }

    @Override
    public Transfer transferBank(Account accountDeposit, Account accountRecipient, double value) {

        Transfer transfer = transactionsBank.transfer(accountRecipient, accountDeposit, value);
        transferRepository.save(transfer);
        return transfer;
    }

    @Override
    public Transfer cashOut(Account account, double value) {

        Transfer transfer = transactionsBank.cashOut(account, value);
        transferRepository.save(transfer);
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
    public Collection<Transfer> getTransfers(Integer idAccount) {

        Collection<Transfer> transfers = transferRepository.findByTransactionWithId(idAccount);
        return transfers;
    }
}
