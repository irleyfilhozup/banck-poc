package com.example.bankpoc.serviceTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.models.TypeTransfer;
import com.example.bankpoc.service.AccountService;
import com.example.bankpoc.service.ClientService;
import com.example.bankpoc.service.TransferService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class BankServiceTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private ClientService clientService;

    @MockBean
    private TransferService transferService;

    private Client client1;
    private Client client2;
    private Collection<Client> allClients;
    private Collection<Transfer> allTrasnfers;

    private  Integer id;
    private Account account1;
    private Account account2;
    private Transfer transfer;

    @Before
    public void setUp() {

         client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
         client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));

         id =1;

        allClients = Arrays.asList(client1, client2);

        account1 = new Account(new Timestamp(System.currentTimeMillis()),200);
        account1.setId(1);
        account2 = new Account(new Timestamp(System.currentTimeMillis()),100);
        account2.setId(2);
        transfer = new Transfer(1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        transfer.setId(1);

        allTrasnfers = Arrays.asList(transfer);
    }

    @Test
    public void getClientsTest() {
        allClients = Arrays.asList(client1, client2);
        given(clientService.findAll()).willReturn(allClients);

        Collection<Client> allClientsResp = clientService.findAll();
        assertNotNull(allClientsResp);
        assertEquals(2, allClientsResp.size());
    }

    @Test
    public void findByIdTest() {
        given(clientService.findOne(id)).willReturn(client1);

        Client client = clientService.findOne(1);
        assertEquals("012.345.678-99", client.getCpf());
    }

    @Test
    public void createClientTest() {
        given(clientService.create(client1)).willReturn(client1);

        Client client = clientService.create(client1);
        assertEquals("012.345.678-99", client.getCpf());
    }

    @Test
    public void updateClientTest() {
        given(clientService.update(client1)).willReturn(client1);

        Client client = clientService.update(client1);
        assertEquals("012.345.678-99", client.getCpf());
    }

    @Test
    public void depositTest() {

        given(transferService.deposit(account1,200)).willReturn(transfer);

        Transfer transferResp = transferService.deposit(account1, 200);
        assertNotNull(transferResp);
    }

    @Test
    public void transferBankTest() {

        given(transferService.transferBank(account1,account2,200)).willReturn(transfer);

        Transfer transferResp = transferService.transferBank(account1, account2,200);
        assertNotNull(transferResp);
    }

    @Test
    public void cashOutTest() {

        given(transferService.cashOut(account1, 200)).willReturn(transfer);

        Transfer transferResp = transferService.cashOut(account1,200);
        assertNotNull(transferResp);
    }

    @Test
    public void getBalanceTest() {

        String resp = "{ \"Balance\" : " + Double.valueOf(String.format(Locale.US, "%.2f", account1.getBalance())) +
                " } ";

        given(transferService.getBalance(id)).willReturn(resp);

        String transferResp = transferService.getBalance(id);
        assertNotNull(transferResp);
    }

    @Test
    public void getTransfersTest() {

        given(transferService.getTransfers(id)).willReturn(allTrasnfers);

        String transferResp = transferService.getBalance(id);
        assertNotNull(allTrasnfers);
        assertEquals(1, allTrasnfers.size());
    }

}
