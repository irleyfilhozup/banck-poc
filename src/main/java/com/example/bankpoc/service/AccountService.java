package com.example.bankpoc.service;

import java.util.Collection;
import java.util.Optional;

import com.example.bankpoc.models.Account;

public interface AccountService {

    Collection<Account> findAll();

    Account findOne(int id);

    Account create(Account newAccount);

    Account update(Account accountUpDate, Integer id);

    void delete(int id);
}
