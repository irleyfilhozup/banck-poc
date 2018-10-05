package com.example.bankpoc.serviceTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.models.TypeTransfer;
import com.example.bankpoc.repository.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;


    private Collection<Transfer> allTrasnfers;

    private Account account1;
    private Account account2;
    private Transfer transfer;

    @Before
    public void setUp() {

        account1 = new Account(new Timestamp(System.currentTimeMillis()),200);
        account1.setId(1);
        account2 = new Account(new Timestamp(System.currentTimeMillis()),100);
        account2.setId(2);
        transfer = new Transfer(1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        transfer.setId(1);

        allTrasnfers = Arrays.asList(transfer);
    }

    @Test
    public void createTest() {

        given(accountRepository.save(account1)).willReturn(account1);

        Account account = accountRepository.save(account1);
        assertNotNull(account);
        assertEquals(1, account.getId(),0);

    }

    @Test
    public void upDateTest() {

        given(accountRepository.save(account1)).willReturn(account1);

        Account account = accountRepository.save(account1);
        assertNotNull(account);
        assertEquals(1, account.getId(),0);

    }
}
