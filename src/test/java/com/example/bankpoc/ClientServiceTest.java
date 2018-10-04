package com.example.bankpoc;


import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.service.ClientService;
import com.example.bankpoc.service.ClientServiceBean;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

 /*   @MockBean
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    List<Client> allClients;

    @Before
    public void setUp() throws Exception {

        clientService = new ClientService();

        Client client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
        client1.setId(1);
        client1.setId_account(1);
        Client client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));
        client2.setId(2);
        client2.setId_account(2);

        allClients = Arrays.asList(client1, client2);

        given(clientRepository.findAll()).willReturn(allClients);

    }

    @Test
    public void testClientsDataBase() {


        Collection<Client> clients = clientService.findAll();
        Assert.assertNotNull(clients);
    }*/
}
