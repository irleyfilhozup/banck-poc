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

    private Validation validation;

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
    public String create(Client newClient) {
        try{
            validation.validClient(newClient);
        } catch (RuntimeException error){
            return error.getMessage();
        }

        Client client = clientRepository.save(newClient);
        return "Cliente Cadastrado!!";
    }

    @Override
    public String update(Client client, Integer id) {
        try {
            validation.validClientUpDdate(client, id);
        }
        catch (RuntimeException error) {
            return error.getMessage();
        }

        client.setId(id);
        Client clientPersisted = clientRepository.save(client);
        return "Cliente editado com sucesso";
    }

    @Override
    public void delete(int id) {

        clientRepository.deleteById(id);
    }
}
