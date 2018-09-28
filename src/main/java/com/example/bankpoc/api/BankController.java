package com.example.bankpoc.api;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
/*
    @RequestMapping(
            value = "/mypoints/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> deletePoint(@PathVariable("id") Integer id, @RequestBody Point point) {

        clientService.delete(id);
        return new ResponseEntity<Point>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/mypoints/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> updatePoints(@RequestBody Point upDatePoint, @PathVariable("id") Integer id) {

        Point point = clientService.update(upDatePoint,id);
        if(point == null) {
            return  new ResponseEntity<Point>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Point>(point, HttpStatus.NO_CONTENT);
    }*/

    @RequestMapping(
            value = "/new/client",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createPoint(@RequestBody Client newClient) {

        clientService.create(newClient);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }

}
