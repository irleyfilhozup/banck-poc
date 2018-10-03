package com.example.bankpoc.validation;

import com.example.bankpoc.exception.account.NegativeBalanceOnAccount;
import com.example.bankpoc.exception.account.PositiveBalanceOnAccount;
import com.example.bankpoc.exception.client.ClientExistsException;
import com.example.bankpoc.exception.client.ClientNotExistsException;
import com.example.bankpoc.exception.client.UnfilledFieldsException;
import com.example.bankpoc.models.Account;
import com.example.bankpoc.models.Client;

public class ValidationDeleteClient {

    private final double minimumValueToCloseAccount = 0;


    public boolean balanceInAccount(Account account) throws PositiveBalanceOnAccount, NegativeBalanceOnAccount {
        if (account.getBalance() >= 0 && account.getBalance() <= minimumValueToCloseAccount) {
            return true;
        } else {
            if (account.getBalance() > minimumValueToCloseAccount) {
                throw new PositiveBalanceOnAccount(account.getBalance());
            } else {
                throw new NegativeBalanceOnAccount(account.getBalance());
            }

        }
    }

    public boolean clientExists(Client client) throws ClientExistsException {

        if(null == client){
            throw new ClientNotExistsException();
        }
        else {
            return true;
        }
    }

    public boolean requiredFields(Client client) throws UnfilledFieldsException {

        if(null == client.getCpf() || null == client.getName() || null == client.getDate_creation()) {
            throw new UnfilledFieldsException();
        }
        else {
            return true;
        }
    }
}