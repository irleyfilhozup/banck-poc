package com.example.bankpoc.service;

import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;

import java.util.Collection;

public interface ClientService {

    Collection<Client> findAll();

    Client findOne(int id);

    Client create(Client newClient);

    Client update(Client clientUpDate);

    String delete(int id);

    boolean clientValid(Client client);

    boolean clientValidDeleted(Client client);
}
