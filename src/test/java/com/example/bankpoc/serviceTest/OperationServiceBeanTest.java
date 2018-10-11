//package com.example.bankpoc.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//
//import java.sql.Timestamp;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Locale;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import com.example.bankpoc.base.BankBaseTest;
//import com.example.bankpoc.models.entity.Account;
//import com.example.bankpoc.models.entity.Client;
//import com.example.bankpoc.models.entity.Transfer;
//import com.example.bankpoc.models.enums.TypeTransfer;
//import com.example.bankpoc.service.interfaceServ.AccountService;
//import com.example.bankpoc.service.implement.OperationServiceBean;
//import com.example.bankpoc.service.interfaceServ.ClientService;
//import com.example.bankpoc.service.interfaceServ.TransferService;
//
//public class OperationServiceBeanTest extends BankBaseTest {
//
//    @InjectMocks
//    private OperationServiceBean bankServiceBean;
//
//    @Mock
//    private ClientService clientService;
//
//    @Mock
//    private AccountService accountService;
//
//    @Mock
//    private TransferService transferService;
//
//    private Client client1;
//    private Client client2;
//    private Collection<Client> allClients;
//    private Collection<Transfer> allTrasnfers;
//
//    private Integer id;
//    private Account account1;
//    private Account account2;
//    private Transfer transfer;
//
//    @Before
//    public void setUp() {
///*
//       // client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
//      //  client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));
//
//        id = 1;
//
//        allClients = Arrays.asList(client1, client2);
//
//        account1 = new Account(new Timestamp(System.currentTimeMillis()), 200);
//        account1.setId(1);
//        account2 = new Account(new Timestamp(System.currentTimeMillis()), 100);
//        account2.setId(2);
//        transfer = new Transfer(1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//        transfer.setId(1);
//
//        allTrasnfers = Arrays.asList(transfer);*/
//    }
//
//    @Test
//    public void getClientsTest() {
///*
//        when(clientService.findAll()).thenReturn(allClients);
//
//        Collection<Client> allClientsResp = clientService.findAll();
//        assertNotNull(allClientsResp);
//        assertEquals(2, allClientsResp.size());  */
//    }
//
//    @Test
//    public void findByIdTest() {
//        /*
//        when(clientService.findOne(id)).thenReturn(client1);
//
//        Client client = bankServiceBean.findById(id);
//        assertNotNull(client);
//        assertEquals(client1.getId(), client.getId());
//        */
//    }
//
//    @Test
//    public void createClientTest() {
///*
//        when(clientService.create(client1)).thenReturn(client1);
//        when(accountService.create( new Account(new Timestamp(System.currentTimeMillis())))).thenReturn(account1);
//
//        Client client = bankServiceBean.createClient(client1);
//        assertEquals("012.345.678-99", client.getCpf());
//        */
//    }
//
//    @Test
//    public void updateClientTest() {
//        /*
//        given(clientService.update(client1)).willReturn(client1);
//
//        Client client = clientService.update(client1);
//        assertEquals("012.345.678-99", client.getCpf());
//        */
//    }
//
//    @Test
//    public void depositTest() {
///*
//        given(transferService.deposit(account1, 200)).willReturn(transfer);
//
//        Transfer transferResp = transferService.deposit(account1, 200);
//        assertNotNull(transferResp);
//        */
//    }
//
//    @Test
//    public void transferBankTest() {
///*
//        given(transferService.transferBank(account1, account2, 200)).willReturn(transfer);
//
//        Transfer transferResp = transferService.transferBank(account1, account2, 200);
//        assertNotNull(transferResp);
//        */
//    }
//
//    @Test
//    public void cashOutTest() {
///*
//        given(transferService.cashOut(account1, 200)).willReturn(transfer);
//
//        Transfer transferResp = transferService.cashOut(account1, 200);
//        assertNotNull(transferResp);
//        */
//    }
//
//    @Test
//    public void getBalanceTest() {
///*
//        String resp = "{ \"Balance\" : " + Double.valueOf(String.format(Locale.US, "%.2f", account1.getBalance())) +
//                " } ";
//
//        given(transferService.getBalance(id)).willReturn(resp);
//
//        String transferResp = transferService.getBalance(id);
//        assertNotNull(transferResp);
//        */
//    }
//
//    @Test
//    public void getTransfersTest() {
///*
//        given(transferService.getTransfers(id)).willReturn(allTrasnfers);
//
//        String transferResp = transferService.getBalance(id);
//        assertNotNull(allTrasnfers);
//        assertEquals(1, allTrasnfers.size());
//        */
//    }
//
//}
