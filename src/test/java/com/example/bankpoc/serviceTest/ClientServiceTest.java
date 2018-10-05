package com.example.bankpoc.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @MockBean
    private ClientRepository clientRepository;

    private Client client1;
    private Client client2;
    private Collection<Client> allClients;
    private int id;

    @Before
    public void setUp() {

        client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
        client2 = new Client("Joana Meireles", "987.951.357-12", new Timestamp(System.currentTimeMillis()));
        id =1;
        allClients = Arrays.asList(client1, client2);
    }

    @Test
    public void getClientsTest() {

        given(clientRepository.findAll()).willReturn((List<Client>) allClients);

        Collection<Client> allClientsResp = clientRepository.findAll();
        assertNotNull(allClientsResp);
        assertEquals(2, allClientsResp.size());
    }

    @Test
    public void createClientTest() {
        given(clientRepository.save(client1)).willReturn(client1);

        Client client = clientRepository.save(client1);
        assertEquals("012.345.678-99", client.getCpf());
    }

    @Test
    public void updateClientTest() {
        given(clientRepository.save(client1)).willReturn(client1);

        Client client = clientRepository.save(client1);
        assertEquals("012.345.678-99", client.getCpf());
    }
}
