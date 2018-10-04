package com.example.bankpoc.validation;

import com.example.bankpoc.exception.client.ClientExistsException;
import com.example.bankpoc.exception.client.ClientNotExistsException;
import com.example.bankpoc.exception.client.UnfilledFieldsException;
import com.example.bankpoc.models.Client;

public class ValidateClient {

    public boolean clientExists(Client client) throws ClientExistsException {

        if(null == client){
            throw new ClientNotExistsException();
        }
        else {
            return true;
        }
    }

    public boolean requiredFields(Client client) throws UnfilledFieldsException {

        if(null == client.getCpf() || null == client.getName() || null == client.getDate_creation()) {
            throw new UnfilledFieldsException();
        }
        else {
            return true;
        }
    }
}
