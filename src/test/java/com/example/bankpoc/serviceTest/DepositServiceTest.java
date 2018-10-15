package com.example.bankpoc.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jmx.export.annotation.ManagedOperation;

import com.example.bankpoc.base.BankBaseTest;
import com.example.bankpoc.models.entity.Deposit;
import com.example.bankpoc.models.request.DepositRequest;
import com.example.bankpoc.repository.DepositRepository;
import com.example.bankpoc.service.implement.DepositServiceImpl;

public class DepositServiceTest extends BankBaseTest {

    @Mock
    private DepositRepository depositRepository;

    @InjectMocks
    private DepositServiceImpl depositService;

    private Deposit deposit;
    private DepositRequest depositRequest;
    private List<Deposit> deposits;

    @Before
    public void setUp() {
        depositRequest = new DepositRequest(1L, 200);
        deposit = new Deposit(depositRequest);
        deposits = new ArrayList<>();
        deposits.add(deposit);
    }

    @Test
    public void createTest() {
        when(depositRepository.save(any(Deposit.class))).thenReturn(deposit);
        Deposit depositresp = depositService.create(deposit);
        assertNotNull(depositresp);
    }

    @Test
    public void findCustomerDepositsTest() {
        when(depositRepository.findCustomerDeposits(anyLong())).thenReturn(deposits);
        List<Deposit> list = depositService.findCustomerDeposits(1L);
        assertEquals(1,list.size());
    }
}
