package com.example.bankpoc.api;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.TransactionsBank;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.service.AccountService;
import com.example.bankpoc.service.ClientService;
import com.example.bankpoc.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;

@RestController
public class BankController {

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransferService transferService;

    TransactionsBank transactionsBank = new TransactionsBank();

    @GetMapping(
            value = "/clients",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Client>> getClients() {

        Collection<Client> clients= clientService.findAll();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/client/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Integer id, @RequestBody Client client) {

        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/client/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody Client upDateClient, @PathVariable("id") Integer id) {

       Client client = clientService.update(upDateClient,id);


            return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/client/new",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {

        Account account = new Account(new Timestamp(System.currentTimeMillis()));
        account = accountService.create(account);

        newClient.setId_account(account.getId());

        Client client = clientService.create(newClient);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/transfer",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> transfer(@RequestBody ObjBodyTransfer objBodyTransfer) {

        Transfer transfer = transferService.transferBank(objBodyTransfer.getIdRecipient(),
                objBodyTransfer.getIdDeposit(), objBodyTransfer.getValue());

        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/deposit",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> deposit(@RequestBody ObjBodyTransfer objBodyTransfer) {

        Transfer transfer = transferService.deposit(objBodyTransfer.getIdRecipient(),objBodyTransfer.getValue());
        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/balance/{idClient}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> balance(@PathVariable("idClient") Integer idClient) {

        String balance = transferService.getBalance(idClient);
        return new ResponseEntity<String>(balance, HttpStatus.OK);
    }

    @RequestMapping(
            value = "cashOut",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> cashOut(@RequestBody ObjBodyTransfer objBodyTransfer) {

        Transfer transfer = transferService.cashOut(objBodyTransfer.getIdDeposit(), objBodyTransfer.getValue());
        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "accountStatement/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Transfer>> accountStatement(@PathVariable("id") Integer id) {

        Collection<Transfer> transfers = transferService.getTransfers(id);
        return new ResponseEntity<Collection<Transfer>>(transfers, HttpStatus.OK);
    }
}
