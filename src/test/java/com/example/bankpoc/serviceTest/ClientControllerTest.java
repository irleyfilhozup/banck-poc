//package com.example.bankpoc.serviceTest;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.sql.Timestamp;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.bankpoc.api.ClientController;
//import com.example.bankpoc.models.entity.CashOut;
//import com.example.bankpoc.models.entity.Client;
//import com.example.bankpoc.models.entity.Deposit;
//import com.example.bankpoc.models.entity.Transfer;
//import com.example.bankpoc.models.enums.TypeTransfer;
//import com.example.bankpoc.service.interfaceServ.OperationService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ClientController.class)
//public class ClientControllerTest {
///*
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private OperationService operationService;
//
//    private ObjectMapper mapper;
//    private int id;
//
//    private Client client1;
//    private Client client2;
//    private List<Client> allClients;
//
//    @Before
//    public void setUp() throws Exception {
//        /*
//        client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
//        client1.setId(1);
//        client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));
//        client2.setId(2);
//
//        mapper = new ObjectMapper();
//
//        allClients = Arrays.asList(client1, client2);
//        */
//    }
//
//  //  @Test
//   // public void getClientsReturnJsonArray() throws Exception {
///*
//        given(operationService.findAllClient()).willReturn(allClients);
//
//        mvc.perform(get("/clients")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));
//      */
//    }
//
//    @Test
//    public void searchforIdReturnJsonArray() throws Exception {
///*
//        id = 1;
//        given(operationService.findById(id)).willReturn(client1);
//
//        mvc.perform(get("/searchClient/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id));
//                */
//    }
//
//    @Test
//    public void upDateClientReturnJsonArray() throws Exception {
//        /*
//        Integer id = 1;
//        Client upDateClient = new Client("Joao da Silva 2", "012.345.678-99",
//                new Timestamp(System.currentTimeMillis()));
//        upDateClient.setId(id);
//        upDateClient.setAccountId(1);
//
//        given(operationService.updateClient(upDateClient, id)).willReturn(upDateClient);
//        ObjectMapper mapper = new ObjectMapper();
//        mvc.perform(put("/client/update/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsBytes(upDateClient)))
//                .andExpect(status().isNoContent());
//                */
//    }
//
//
//    @Test
//    public void newCLientOkReturnJsonArray() throws Exception {
//        /*
//        Integer id = 1;
//        Client newClient = new Client("Joao da Silva","012.345.678-99", new Timestamp(System.currentTimeMillis()));
//        newClient.setId(1);
//
//        given(operationService.createClient(newClient)).willReturn(newClient);
//
//        mvc.perform(post("/client/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsBytes(newClient)))
//                .andExpect(status().isCreated());
//
//        Client client = operationService.createClient(client1);
//        */
//    }
//
//    @Test
//    public void transferReturnJsonArray() throws Exception {
//        /*
//        ObjBodyTransfer objBodyTransfer = new ObjBodyTransfer(1,2,200);
//
//
//        Transfer transfer = new Transfer(2, 1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//
//        given(operationService.transferBank(objBodyTransfer)).willReturn(transfer);
//
//        mvc.perform(post("/client/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsBytes(objBodyTransfer)))
//                .andExpect(status().isCreated());
//                */
//    }
//
//    @Test
//    public void depositReturnJsonArray() throws Exception {
///*
//        ObjBodyDepositCashOut objBodyDepositCashOut = new ObjBodyDepositCashOut(1,200);
//
//        Deposit deposit = new Deposit(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//
//        given(operationService.deposit(objBodyDepositCashOut)).willReturn(deposit);
//
//        mvc.perform(post("/client/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsBytes(objBodyDepositCashOut)))
//                .andExpect(status().isCreated());
//                */
//    }
//
//    @Test
//    public void balanceReturnJsonArray() throws Exception {
///*
//        id = 1;
//
//        String resp = "{ \"Balance\" : "+ 200 + " } ";
//       // Collection<Transfer> transfers = Arrays.asList(transfer, transfer1, transfer2);
//        given(operationService.getBalance(id)).willReturn(resp);
//
//        mvc.perform(get("/balance/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//                */
//    }
//
//    @Test
//    public void cashOutReturnJsonArray() throws Exception {
///*
//        ObjBodyDepositCashOut objBodyDepositCashOut = new ObjBodyDepositCashOut(1,200);
//        // Integer id_account, double value, Timestamp date, TypeTransfer type_transfer
//        CashOut cashOut = new CashOut(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//
//
//
//        given(operationService.cashOut(objBodyDepositCashOut)).willReturn(cashOut);
//
//        mvc.perform(post("/client/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsBytes(objBodyDepositCashOut)))
//                .andExpect(status().isCreated());
//                */
//    }
//
//    @Test
//    public void accountStatmentReturnJsonArray() throws Exception {
///*
//        int id = 1;
//        Transfer transfer = new Transfer(2, 1, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//        Transfer transfer1 = new Transfer(1, 2, 100, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//        Transfer transfer2 = new Transfer(2 , 1, 500, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
//
//        List<Transfer> transfers = Arrays.asList(transfer, transfer1, transfer2);
//        given(operationService.getTransfers(id)).willReturn(transfers);
//
//        mvc.perform(get("/accountStatement/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//                */
//    }
//
//
//}
