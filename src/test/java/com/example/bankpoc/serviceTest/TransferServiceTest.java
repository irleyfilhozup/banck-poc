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

import com.example.bankpoc.base.BankBaseTest;
import com.example.bankpoc.models.entity.Transfer;
import com.example.bankpoc.models.request.TransferRequest;
import com.example.bankpoc.repository.TransferRepository;
import com.example.bankpoc.service.implement.TransferServiceImpl;

public class TransferServiceTest extends BankBaseTest {

    @Mock
    private TransferRepository transferRepository;

    @InjectMocks
    private TransferServiceImpl transferService;

    private TransferRequest transferRequest;
    private Transfer transfer;
    private List<Transfer> list;

    @Before
    public void setUp() {
        transferRequest = new TransferRequest(1L,2L,200);
        transfer = new Transfer(transferRequest);
        list = new ArrayList<>();
        list.add(transfer);
    }

    @Test
    public void transferTest() {
        when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);
        Transfer transferResp = transferService.transfer(transferRequest);
        assertNotNull(transferResp);
    }

    @Test
    public void getTransfersTest() {
        when(transferRepository.findByTransactionWithId(anyLong())).thenReturn(list);
        List<Transfer> transfers = transferService.getTransfers(1L);
        assertEquals(1,transfers.size());
    }
}
