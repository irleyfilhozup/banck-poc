package com.example.bankpoc.models.entity;

import java.time.LocalDateTime;

import com.example.bankpoc.models.enums.TypeTransfer;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    private Long accountIdDesposit;
    private Long accountIdRecipient;
    private LocalDateTime date;
    private double value;
    private String typeTrasnfer;

    public Transaction(Long accountIdDesposit, Long accountIdRecipient, LocalDateTime date, double value, TypeTransfer type) {
        this.accountIdDesposit = accountIdDesposit;
        this.accountIdRecipient = accountIdRecipient;
        this.date = date;
        this.value = value;
        this.typeTrasnfer = type.name();
    }

    public Transaction(Long accountIdDesposit, LocalDateTime date, double value, TypeTransfer type) {
        this.accountIdDesposit = accountIdDesposit;
        this.date = date;
        this.value = value;
        this.typeTrasnfer = type.name();
    }

    public Transaction(LocalDateTime date, Long accountIdRecipient,  double value, TypeTransfer type) {
        this.accountIdRecipient = accountIdRecipient;
        this.date = date;
        this.value = value;
        this.typeTrasnfer = type.name();
    }

    public Long getAccountIdDesposit() {
        return accountIdDesposit;
    }

    public void setAccountIdDesposit(Long accountIdDesposit) {
        this.accountIdDesposit = accountIdDesposit;
    }

    public Long getAccountIdRecipient() {
        return accountIdRecipient;
    }

    public void setAccountIdRecipient(Long accountIdRecipient) {
        this.accountIdRecipient = accountIdRecipient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTypeTrasnfer() {
        return typeTrasnfer;
    }

    public void setTypeTrasnfer(String typeTrasnfer) {
        this.typeTrasnfer = typeTrasnfer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountIdDesposit=" + accountIdDesposit +
                ", accountIdRecipient=" + accountIdRecipient +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
