package com.example.service.interfaceSercice;

import com.example.domain.entity.Account;

public interface AccountService {

    Account findById(Long id);

    Account create(Account newAccount);

    Account update(Account account);

    void checkIfAccountExists(Account account);
}
