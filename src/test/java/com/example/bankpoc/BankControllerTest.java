package com.example.bankpoc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bankpoc.api.BankController;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyDepositCashOut;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.models.TypeTransfer;
import com.example.bankpoc.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
public class BankControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BankService bankService;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getClientsReturnJsonArray() throws Exception {

        Client client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
        Client client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));

        List<Client> allClients = Arrays.asList(client1, client2);

        given(bankService.findAllClient()).willReturn(allClients);

        mvc.perform(get("/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void searchforIdReturnJsonArray() throws Exception {
        Integer id = 1;
        Client client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
        client1.setId(1);

        given(bankService.findById(id)).willReturn(client1);

        mvc.perform(get("/searchClient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void upDateClientReturnJsonArray() throws Exception {
        Integer id = 1;
        Client upDateClient = new Client("Joao da Silva 2", "012.345.678-99",
                new Timestamp(System.currentTimeMillis()));
        upDateClient.setId(id);
        upDateClient.setId_account(1);

        given(bankService.updateClient(upDateClient, id)).willReturn(upDateClient);
        ObjectMapper mapper = new ObjectMapper();
        mvc.perform(put("/client/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(upDateClient)))
                .andExpect(status().isNoContent());
    }


    @Test
    public void newCLientOkReturnJsonArray() throws Exception {
        Integer id = 1;
        Client newClient = new Client("Joao da Silva","012.345.678-99", new Timestamp(System.currentTimeMillis()));
        newClient.setId(1);

        given(bankService.createClient(newClient)).willReturn(newClient);

        mvc.perform(post("/client/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(newClient)))
                .andExpect(status().isCreated());
    }

    @Test
    public void transferReturnJsonArray() throws Exception {
        ObjBodyTransfer objBodyTransfer = new ObjBodyTransfer(1,2,200);
        Transfer transfer = new Transfer(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);

        given(bankService.transferBank(objBodyTransfer)).willReturn(transfer);

        mvc.perform(post("/client/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(objBodyTransfer)))
                .andExpect(status().isCreated());
    }

    @Test
    public void depositReturnJsonArray() throws Exception {

        ObjBodyDepositCashOut objBodyDepositCashOut = new ObjBodyDepositCashOut(1,200);

        Transfer transfer = new Transfer(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);

        given(bankService.deposit(objBodyDepositCashOut)).willReturn(transfer);

        mvc.perform(post("/client/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(objBodyDepositCashOut)))
                .andExpect(status().isCreated());
    }

    @Test
    public void balanceReturnJsonArray() throws Exception {

        Integer id = 1;

        String resp = "{ \"Balance\" : "+ 200 + " } ";
       // Collection<Transfer> transfers = Arrays.asList(transfer, transfer1, transfer2);
        given(bankService.getBalance(id)).willReturn(resp);

        mvc.perform(get("/balance/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void cashOutReturnJsonArray() throws Exception {

        ObjBodyDepositCashOut objBodyDepositCashOut = new ObjBodyDepositCashOut(1,200);

        Transfer transfer = new Transfer(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);

        given(bankService.deposit(objBodyDepositCashOut)).willReturn(transfer);

        mvc.perform(post("/client/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(objBodyDepositCashOut)))
                .andExpect(status().isCreated());
    }

    @Test
    public void accountStatmentReturnJsonArray() throws Exception {

        int id = 1;
        Transfer transfer = new Transfer(2, 200, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        Transfer transfer1 = new Transfer(2, 100, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);
        Transfer transfer2 = new Transfer(2, 500, new Timestamp(System.currentTimeMillis()), TypeTransfer.DEPOSIT);

        Collection<Transfer> transfers = Arrays.asList(transfer, transfer1, transfer2);
        given(bankService.getTransfers(id)).willReturn(transfers);

        mvc.perform(get("/accountStatement/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
