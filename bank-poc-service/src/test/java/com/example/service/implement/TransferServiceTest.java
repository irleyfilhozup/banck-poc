package com.example.service.implement;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.domain.entity.Transfer;
import com.example.domain.request.TransferRequest;
import com.example.repository.TransferRepository;
import com.example.service.base.BankBaseTest;

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
        transfer.setId(1L);
        transfer.setAccountIdDesposit(1L);
        transfer.setAccountIdRecipient(2L);
        transfer.setDate(LocalDateTime.now());
        transfer.setValue(200);
        list = new ArrayList<>();
        list.add(transfer);
    }

    @Test
    public void transferTest_WhenPassedValidDataReturnTransfer() {
        when(transferRepository.save(any(Transfer.class))).thenReturn(transfer);
        Transfer transferResp = transferService.transfer(transferRequest);
        assertEquals(transfer.getId(),transferResp.getId());
        assertEquals(transfer.getAccountIdDesposit(),transferResp.getAccountIdDesposit());
        assertEquals(transfer.getAccountIdRecipient(),transferResp.getAccountIdRecipient());
        assertEquals(transfer.getDate(),transferResp.getDate());
        assertEquals(transfer.getValue(),transferResp.getValue(),0);
        assertEquals(transfer.toString(),transferResp.toString());
    }

    @Test
    public void getTransfersTest_WhenPassedValidDataReturnListTransfer() {
        when(transferRepository.findByTransactionWithId(anyLong())).thenReturn(list);
        List<Transfer> transfers = transferService.getTransfers(1L);
        assertEquals(1,transfers.size());
    }
}
