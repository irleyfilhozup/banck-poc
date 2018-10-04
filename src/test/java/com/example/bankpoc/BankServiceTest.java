package com.example.bankpoc;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.repository.AccountRepository;
import com.example.bankpoc.repository.ClientRepository;
import com.example.bankpoc.repository.TransferRepository;
import com.example.bankpoc.service.AccountService;
import com.example.bankpoc.service.BankService;
import com.example.bankpoc.service.ClientService;
import com.example.bankpoc.service.TransferService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BankServiceTest {

    /*@TestConfiguration
    static class BankServiceConfiguration {

        @Bean
        public BankService poiService() {
            return new BankService();
        }
    }*/

 //   @Autowired
  //  private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TransferRepository transferRepository;


    @MockBean
    private AccountService accountService;

    @MockBean
    private BankService bankService;



    @MockBean
    TransferService transferService;

    @Before
    public void setUp() {
        Client client1 = new Client("Joao da Silva","012.345.678-99", new Timestamp(System.currentTimeMillis()));
        Client client2 = new Client("Joana Meireles","987.951.357-12", new Timestamp(System.currentTimeMillis()));

        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(client1));
        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2));
    }

    @Test
    public void validId() {
        Integer id1 = 1;
        Optional<Client> clientFound = clientRepository.findById(1);
        Client client = clientFound.get();

        assertThat(client.getId()).isEqualTo(id1);
    }
}
