package com.example.bankpoc.service;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class ClientServiceBean implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Collection<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findOne(int id) {
        return null;
    }

    @Override
    public Client create(Client point) {
        return null;
    }

    @Override
    public Client update(Client point, Integer id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
