package com.example.bankpoc.api;


import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyDepositCashOut;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.service.AccountService;
import com.example.bankpoc.service.BankService;
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

import java.util.Collection;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransferService transferService;

    @GetMapping(
            value = "/clients",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Client>> getClients() {

        Collection<Client> clients= bankService.findAllClient();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

  /*  @RequestMapping(
            value = "/client/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id, @RequestBody Client client) {

        bankService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

    @RequestMapping(
            value = "/client/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody Client upDateClient, @PathVariable("id") Integer id) {

        Client client = bankService.updateClient(upDateClient, id);
        return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/client/new",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) throws RuntimeException {

        Client client = bankService.createClient(newClient);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/transfer",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> transfer(@RequestBody ObjBodyTransfer objBodyTransfer) {

        Transfer transfer = bankService.transferBank(objBodyTransfer);
        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/deposit",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> deposit(@RequestBody ObjBodyDepositCashOut objBody) {

        Transfer transfer = bankService.deposit(objBody);
        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/balance/{idClient}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> balance(@PathVariable("idClient") Integer idClient) {

        String balance = bankService.getBalance(idClient);
        return new ResponseEntity<String>(balance, HttpStatus.OK);
    }

    @RequestMapping(
            value = "cashOut",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> cashOut(@RequestBody ObjBodyDepositCashOut objBody) {

        Transfer transfer = bankService.cashOut(objBody);
        return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "accountStatement/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Transfer>> accountStatement(@PathVariable("id") Integer id) {

        Collection<Transfer> transfers = bankService.getTransfers(id);
        return new ResponseEntity<Collection<Transfer>>(transfers, HttpStatus.OK);
    }
}
