package com.example.bankpoc.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.bankpoc.exception.client.ClientNotExistsException;
import com.example.bankpoc.exception.client.InvalidValueException;
import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;
import com.example.bankpoc.models.ObjBodyDepositCashOut;
import com.example.bankpoc.models.ObjBodyTransfer;
import com.example.bankpoc.models.Transfer;
import com.example.bankpoc.validation.ValidateCreationClient;
import com.example.bankpoc.validation.ValidateObjBodyTransfer;
import com.example.bankpoc.validation.ValidateTransactionValue;
import com.example.bankpoc.validation.ValidateClient;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class BankServiceBean implements   BankService {

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransferService transferService;

    private ValidateClient validateClient = new ValidateClient();

    private ValidateCreationClient validateCreationClient = new ValidateCreationClient();

    private ValidateObjBodyTransfer validateObjBodyTransfer = new ValidateObjBodyTransfer();

    private ValidateTransactionValue validateTransactionValue = new ValidateTransactionValue();

    @Override
    public Collection<Client> findAllClient() {
        return clientService.findAll();
    }

    @Override
    public Client findById(Integer id) {
        return clientService.findOne(id);
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Client createClient(Client newClient) {


        validateCreationClient.requiredFields(newClient);
        clientService.clientValid(newClient);

        Account account = new Account(new Timestamp(System.currentTimeMillis()));
        account = accountService.create(account);

        newClient.setId_account(account.getId());
        Client client = clientService.create(newClient);

        return client;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Client updateClient(Client clientUpDate, Integer id) {

        Client clientPersisted = clientService.findOne(id);

        validateClient.clientExists(clientPersisted);
        validateCreationClient.requiredFields(clientUpDate);

        clientUpDate.setId(id);
        Client client = clientService.update(clientUpDate);
        return client;
    }

    @Override
    public boolean deleteClient(int id) {

        Client clientDelete = clientService.findOne(id);
        clientService.clientValidDeleted(clientDelete);

        clientService.delete(id);
        accountService.delete(clientDelete.getId_account());

        Account accountDelete = accountService.findOne(clientDelete.getId_account());
        accountService.accountValidDeleted(accountDelete);

        return true;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Transfer deposit(ObjBodyDepositCashOut objBody) throws ClientNotExistsException, InvalidValueException {

        Client client = clientService.findOne(objBody.getIdClient());
        validateClient.clientExists(client);
        Account account = accountService.findOne(client.getId_account());

        Transfer transfer = transferService.deposit(account, objBody.getValue());

        accountService.update(account, account.getId());
        return transfer;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Transfer transferBank(ObjBodyTransfer objBodyTransfer) {

        validateObjBodyTransfer.check(objBodyTransfer);
        validateObjBodyTransfer.validValue(objBodyTransfer.getValue());

        Client clientDeposit = clientService.findOne(objBodyTransfer.getIdDeposit());
        Client clientRecipient = clientService.findOne(objBodyTransfer.getIdRecipient());

        validateClient.clientExists(clientDeposit);
        validateClient.clientExists(clientRecipient);

        Account accountDeposit = accountService.findOne(clientDeposit.getId_account());
        Account accountRecipient = accountService.findOne(clientRecipient.getId_account());

        validateTransactionValue.valueInAccount(accountDeposit, objBodyTransfer.getValue());

        Transfer transfer = transferService.transferBank(accountDeposit, accountRecipient, objBodyTransfer.getValue());

        accountService.update(accountRecipient, clientRecipient.getId_account());
        accountService.update(accountDeposit, clientDeposit.getId_account());

        return transfer;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Transfer cashOut(ObjBodyDepositCashOut objBody) {

        validateTransactionValue.checkCashOut(objBody.getValue());

        Client client = clientService.findOne(objBody.getIdClient());
        validateClient.clientExists(client);

        Account account = accountService.findOne(client.getId_account());
        validateTransactionValue.valueInAccount(account, objBody.getValue());

        Transfer transfer = transferService.cashOut(account, objBody.getValue());

        accountService.update(account, account.getId());

        return transfer;
    }

    @Override
    public String getBalance(int idClient) {

        Client client = clientService.findOne(idClient);
        validateClient.clientExists(client);

        Account account = accountService.findOne(client.getId_account());
        return "{ \"Balance\" : " + Double.valueOf(String.format(Locale.US, "%.2f", account.getBalance())) + " } ";
    }

    @Override
    public Collection<Transfer> getTransfers(Integer id) {

        Client client = clientService.findOne(id);
        validateClient.clientExists(client);
        Account account = accountService.findOne(client.getId_account());
        Collection<Transfer> transfers = transferService.getTransfers(account.getId());

        return transfers;
    }
}
