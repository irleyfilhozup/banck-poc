package com.example.bankpoc.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.repository.AccountRepository;
import com.example.bankpoc.validation.ValidationDeleteClient;


@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class AccountServiceBean implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private ValidationDeleteClient validationDeleteClient = new ValidationDeleteClient();

    @Override
    public Collection<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findOne(int id) {

        Optional<Account> account = accountRepository.findById(id);
        return account.get();
    }

    @Override
    public Account create(Account newAccount) {
        Account account = accountRepository.save(newAccount);
        return account;
    }

    @Override
    public Account update(Account accountUpDate, Integer id) {

        Optional<Account> clientPersisted = accountRepository.findById(id);

        if (null == clientPersisted || !clientPersisted.isPresent()) {
            throw new RuntimeException();
        }
        accountUpDate.setId(id);
        Account account = accountRepository.save(accountUpDate);
        return account;
    }

    @Override
    public void accountValidDeleted(Account account) {

        validationDeleteClient.balanceInAccount(account);

    }
}
