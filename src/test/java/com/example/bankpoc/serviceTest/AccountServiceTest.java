package com.example.bankpoc.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.bankpoc.base.BankBaseTest;
import com.example.bankpoc.exception.BusinessException;
import com.example.bankpoc.exception.NotFoundException;
import com.example.bankpoc.models.entity.Account;
import com.example.bankpoc.repository.AccountRepository;
import com.example.bankpoc.service.implement.AccountServiceImpl;
import static org.mockito.Mockito.when;

public class AccountServiceTest extends BankBaseTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    private Long id;
    private Account account1;
    private Optional<Account> accountOptional;

    @Before
    public void setUp() {
        id = 1L;
        account1 = new Account(LocalDateTime.now());
        account1.setId(1L);
        accountOptional = Optional.of(account1);
    }

    @Test
    public void findById_Test_Ok() {
        when(accountRepository.findById(anyLong())).thenReturn(accountOptional);
        Account account = accountService.findById(1L);
        assertNotNull(account);
    }

    @Test
    public void findById_Test_Error() {
        Optional<Account> accountOptional1;
        accountOptional1 = Optional.ofNullable(null);
        when(accountRepository.findById(anyLong())).thenReturn(accountOptional1);
        try {
            accountService.findById(1L);
        }
        catch (NotFoundException exception) {
            assertEquals("Conta Inexistente",exception.getMessage());
        }
    }

    @Test
    public void create_Test() {
        when(accountRepository.save(any(Account.class))).thenReturn(account1);
        Account account = accountService.create(account1);
        assertNotNull(account);
    }

    @Test
    public void update_Test() {
        when(accountRepository.save(any(Account.class))).thenReturn(account1);
        Account account = accountService.update(account1);
        assertNotNull(account);
    }

    @Test
    public void checkIfAccountExists_Test() {
        Account account = null;
        try {
            accountService.checkIfAccountExists(account);
        }
        catch (NotFoundException exception) {
            assertEquals("Conta Inexistente",exception.getMessage());
        }
    }

    @Test
    public void checkIfAccountExists_Test2() {

        accountService.checkIfAccountExists(account1);
        assertEquals(1,1);
    }
}
