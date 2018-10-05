package com.example.bankpoc.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.TransactionsBank;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.models.TypeTransfer;
import com.example.bankpoc.repository.TransferRepository;
import com.example.bankpoc.service.TransferService;

@RunWith(SpringRunner.class)
public class TransferServiceTest {

    @MockBean
    private TransferRepository transferRepository;

    private Transfer transfer1;
    private Transfer transfer2;
    private Collection<Transfer> allTrasnfers;

    @Before
    public void setUp() {

        transfer1 = new Transfer(1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        transfer1.setId(1);

        transfer2 = new Transfer(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        transfer2.setId(2);

        allTrasnfers = Arrays.asList(transfer1, transfer2);
    }

    @Test
    public void depositTest() {

        given(transferRepository.save(transfer1)).willReturn(transfer1);

        Transfer transferResp = transferRepository.save(transfer1);
        assertNotNull(transferResp);
        assertEquals(200, transfer1.getValue(),200);
    }

    @Test
    public void transferBankTest() {

        given(transferRepository.save(transfer1)).willReturn(transfer1);

        Transfer transferResp = transferRepository.save(transfer1);
        assertNotNull(transferResp);
        assertEquals(200, transfer1.getValue(),200);
    }

    @Test
    public void cashOutTest() {

        given(transferRepository.save(transfer1)).willReturn(transfer1);

        Transfer transferResp = transferRepository.save(transfer1);
        assertNotNull(transferResp);
        assertEquals(200, transfer1.getValue(),200);
    }
}
