package com.example.bankpoc.validation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bankpoc.exception.ClientExistsException;
import com.example.bankpoc.exception.ClientNotExistsException;
import com.example.bankpoc.exception.UnfilledFieldsException;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.service.ClientService;

public class Validation {

    @Autowired
    ClientService clientService;

    public boolean validClient(Client client) throws ClientExistsException, UnfilledFieldsException {

        return requiredFields(client) && clientExists(client);
    }

    public Client validClientUpDdate(Client client, int id) throws ClientNotExistsException, UnfilledFieldsException{

        if(requiredFields(client)) {
            client = clientService.findOne(id);
            if (client.getId()==null) {
                throw new ClientNotExistsException(client.getName(), client.getCpf());
            }
        }
        return client;
    }

    private boolean clientExists(Client client) throws ClientExistsException {
/*
        Collection<Client> clients = clientService.findAll();
        for(Client clientList : clients) {
            if(clientList.getCpf().equals(client.getCpf())) {
                throw new ClientExistsException(client.getName(), client.getCpf());
            }
        }*/
        return true;
    }

    private boolean requiredFields(Client client) throws UnfilledFieldsException {

        if(client.getCpf()!=null && client.getName()!=null && client.getDate_creation()!=null) {
            return true;
        }
        throw new UnfilledFieldsException();
    }
}
