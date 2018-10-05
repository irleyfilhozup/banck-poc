package com.example.bankpoc.ValidateTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bankpoc.models.Client;
import com.example.bankpoc.validation.ValidateClient;

@RunWith(SpringRunner.class)
public class ValidationClientTest {

    private ValidateClient validateClient = new ValidateClient();

    private Client client1;
    private Client client2;
    private boolean resp;

    @Before
    public void setUp() {

        client1 = new Client("Joao da Silva", "012.345.678-99", new Timestamp(System.currentTimeMillis()));
        client1.setId_account(1);
        client1.setId(1);
        client2 = new Client("Joana Meireles", null, new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void ValidateCLientExistOk() {

        try {
            resp = validateClient.clientExists(client1);
            assertTrue(resp);
        } catch (RuntimeException e) {
            assertEquals("Cliente: " + client1.getName() + ", CPF: " + client1.getCpf() + " não existe no banco de dados!!",
                    e.getMessage());
        }
    }

    @Test
    public void ValidateCLientExistError() {

        Client client = new Client();
        try {
            resp = validateClient.clientExists(client);
            assertTrue(resp);
        } catch (RuntimeException e) {
            assertEquals("Cliente: " + client1.getName() + ", CPF: " + client1.getCpf() + " não existe no banco de dados!!",
                    e.getMessage());
        }
    }

    @Test
    public void requiredFieldsOkTest() {

        try {
            resp = validateClient.requiredFields(client1);
            assertTrue(resp);
        } catch (RuntimeException e) {
            assertEquals("Campos não preenchidos", e.getMessage());
        }
    }

    @Test
    public void requiredFieldsErrorTest() {

        try {
            resp = validateClient.requiredFields(client2);
            assertTrue(resp);
        } catch (RuntimeException e) {
            assertEquals("Campos não preenchidos", e.getMessage());
        }
    }
}
