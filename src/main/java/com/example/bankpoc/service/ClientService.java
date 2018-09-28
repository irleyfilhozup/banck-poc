package com.example.bankpoc.service;

import com.example.bankpoc.models.Client;

import java.util.Collection;

public interface ClientService {

    Collection<Client> findAll();

    Client findOne(int id);

    Client create(Client point);

    Client update(Client point, Integer id);

    void delete(int id);
}
