package com.example.bankpoc.service;

import com.example.bankpoc.exception.ClientNotExistsException;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.validation.Validation;

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

    private Validation validation = new Validation();

    @Override
    public Collection<Client> findAll() {

        return clientRepository.findAll();
    }

    @Override
    public Client findOne(int id) throws ClientNotExistsException {

        Optional<Client> client = clientRepository.findById(id);
        if (null == client || !client.isPresent()) {
            throw new ClientNotExistsException();
        }
        return client.get();
    }

    @Override
    public Client create(Client newClient) throws RuntimeException {

        Client client = clientRepository.save(newClient);
        return client;
    }

    @Override
    public Client update(Client clientUpDate, Integer id) {

        Optional<Client> clientPersisted = clientRepository.findById(id);

        if (null == clientPersisted || !clientPersisted.isPresent()) {
            throw new ClientNotExistsException();
        }
        clientUpDate.setId(id);
        Client client = clientRepository.save(clientUpDate);
        return client;
    }

    @Override
    public void delete(int id) {
        Optional<Client> clientPersisted = clientRepository.findById(id);

        if (null == clientPersisted || !clientPersisted.isPresent()) {
            throw new ClientNotExistsException();
        }
        clientRepository.deleteById(id);
    }
}
