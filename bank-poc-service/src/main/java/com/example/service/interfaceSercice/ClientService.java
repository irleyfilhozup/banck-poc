package com.example.service.interfaceSercice;

import com.example.domain.entity.Client;
import com.example.domain.request.ClientRequest;
import com.example.domain.response.ClientResponse;

public interface ClientService {

    ClientResponse findByAccountIdResponse(Long accountId);

    Client findByAccountId(Long accountId);

    ClientResponse findByCpf(String cpf);

    ClientResponse create(ClientRequest clientRequest);

    ClientResponse update(ClientRequest clientRequest, Long accountId);

    void checkIfClientExists(Client client);

    void checkIfCPFExists(String cpf);

    void checkIfClientNotExists(Client client);
}
