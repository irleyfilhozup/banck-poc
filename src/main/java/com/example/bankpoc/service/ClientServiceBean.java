package com.example.bankpoc.service;

import com.example.bankpoc.exception.client.ClientExistsException;
import com.example.bankpoc.exception.client.ClientNotExistsException;
import com.example.bankpoc.exception.client.UnfilledFieldsException;
import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.validation.ValidateClient;
import com.example.bankpoc.validation.ValidateCreationClient;
import com.example.bankpoc.validation.ValidationDeleteClient;

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

    private ValidateCreationClient validateCreationClient = new ValidateCreationClient();

    private ValidationDeleteClient validationDeleteClient = new ValidationDeleteClient();

    private ValidateClient validateClient = new ValidateClient();

    @Override
    public Collection<Client> findAll() {

        return clientRepository.findAll();
    }

    @Override
    public Client findOne(int id) throws ClientNotExistsException {

        Optional<Client> clientOpt = clientRepository.findById(id);
        if (null == clientOpt || !clientOpt.isPresent()) {
            throw new ClientNotExistsException();
        }
        Client client = clientOpt.get();
        validateClient.clientExists(client);

        return client;
    }

    @Override
    public Client create(Client newClient) throws RuntimeException {

        Client client = clientRepository.save(newClient);
        return client;
    }

    @Override
    public Client update(Client clientUpDate) {

       Client client = clientRepository.save(clientUpDate);
       return client;
    }

    @Override
    public String delete(int id) {

        clientRepository.deleteById(id);
        Optional<Client> clientPersisted = clientRepository.findById(id);

        if (null == clientPersisted || !clientPersisted.isPresent()) {
            return "Response: " + "Cliente não existe na base de dados.";

        }
        try {
            clientRepository.deleteById(id);
            return "Response: " + "Cliente deletado do banco de dados.";
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return "Response: " + "O sistema não pode excluir o cliente.";
        }
    }

    @Override
    public boolean clientValid(Client client) throws UnfilledFieldsException, ClientExistsException{

        Client clientReturn = clientRepository.findByCpf(client.getCpf());
        validateCreationClient.clientExists(clientReturn);
        return true;
    }

    @Override
    public boolean clientValidDeleted(Client client) {
        validationDeleteClient.clientExists(client);
        validationDeleteClient.requiredFields(client);
        return true;
    }



}
