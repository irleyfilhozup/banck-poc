package com.example.bankpoc.validation;

import com.example.bankpoc.exception.client.InvalidValueException;
import com.example.bankpoc.exception.client.UnfilledFieldsException;
import com.example.bankpoc.exception.tranfer.DepositEqualsRecipientException;
import com.example.bankpoc.models.ObjBodyTransfer;

public class ValidateObjBodyTransfer {

    private final double minimumValueForTransfer = 0;

    public void check(ObjBodyTransfer objBodyTransfer) throws UnfilledFieldsException, DepositEqualsRecipientException {

        if(null == objBodyTransfer.getIdRecipient() ||
                null == objBodyTransfer.getIdDeposit()) {

            throw new UnfilledFieldsException();
        }

        if(objBodyTransfer.getIdDeposit().equals(objBodyTransfer.getIdRecipient())) {
            throw new  DepositEqualsRecipientException();
        }
    }

    public void validValue(double value) throws  InvalidValueException{

        if (value<=0 || value <minimumValueForTransfer) {
            throw new InvalidValueException(value);
        }
    }
}
