package com.example.bankpoc.api;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BankController {

    @Autowired
    ClientService clientService;

    @RequestMapping(
            value = "/clients",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Client>> getClients() {

        Collection<Client> clients= clientService.findAll();

        return new ResponseEntity<Collection<Client>>(clients, HttpStatus.OK);
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

        if(client == null) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/new/client",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {

        clientService.create(newClient);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }

}
