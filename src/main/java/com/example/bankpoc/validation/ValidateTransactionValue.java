package com.example.bankpoc.validation;

import com.example.bankpoc.exception.client.InvalidValueException;
import com.example.bankpoc.models.Account;

public class ValidateTransactionValue {

    private final double minimumValueForCashOut = 0;

    private final double minimumValueForDeposit = 1;

    public void checkCashOut(double value) throws InvalidValueException {

        if (value<=0 || value <minimumValueForCashOut) {
            throw new InvalidValueException(value);
        }
    }

    public void checkDeposit(double value) throws InvalidValueException {

        if (value >=minimumValueForDeposit) {
            throw new InvalidValueException(value);
        }
    }

    public void valueInAccount(Account account, double valueTranfer) throws InvalidValueException {

        if (account.getBalance() < valueTranfer) {
            throw new InvalidValueException(valueTranfer);
        }
    }
}
