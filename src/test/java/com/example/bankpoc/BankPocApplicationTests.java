package com.example.bankpoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.service.ClientService;
import com.example.bankpoc.service.ClientServiceBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankPocApplicationTests {


	ClientServiceBean clientService;

	@Mock
	ClientRepository clientRepository;

	private List<Client> listClients;

	@Before
	public void setUp() throws Exception {
		clientService = new ClientServiceBean();
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testClientsDataBase() {

		Mockito.when(clientService.findAll()).thenReturn(listClients);
		Collection<Client> clients = clientService.findAll();
		Assert.assertNotNull(clients);
	}

//	@Test
//	public void testNewClient(){
//
//		Client client1 = new Client("Romario Morais", "222.222.444-55", new Date(System.currentTimeMillis()));
//		Client clientCadas = clientService.create(client1);
//		assertNotNull(clientCadas);
//	}
}
