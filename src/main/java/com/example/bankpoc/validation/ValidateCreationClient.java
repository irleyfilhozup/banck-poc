package com.example.bankpoc.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bankpoc.exception.client.ClientExistsException;
import com.example.bankpoc.exception.client.ClientNotExistsException;
import com.example.bankpoc.exception.client.UnfilledFieldsException;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.service.ClientService;

public class ValidateCreationClient {

    @Autowired
    ClientService clientService;




    public boolean clientExists(Client client) throws ClientExistsException {

        if(null == client){
            return true;
        }
        else {
            throw new ClientExistsException(client.getName(), client.getCpf());
        }
    }

    public boolean requiredFields(Client client) throws UnfilledFieldsException {

        if(null == client.getCpf() || null == client.getName() || null == client.getDate_creation()) {
            throw new UnfilledFieldsException();
        }
        else {
            if(client.getCpf().length()<11 || client.getName().length()<1) {
                throw new UnfilledFieldsException();
            }
            return true;
        }
    }
}
