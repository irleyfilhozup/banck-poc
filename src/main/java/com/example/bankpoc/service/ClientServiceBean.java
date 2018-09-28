package com.example.bankpoc.service;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

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

        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public Client create(Client newClient) {

        Client client = clientRepository.save(newClient);
        return client;
    }

    @Override
    public Client update(Client client, Integer id) {

        Optional<Client> clientUpDate = clientRepository.findById(id);

        if (clientUpDate.get()==null) {
            return null;
        }

        client.setId(id);
        Client clientPersisted = clientRepository.save(client);
        return clientPersisted;

    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}
