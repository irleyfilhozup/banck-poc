package com.example.bankpoc.models.response;

import java.time.LocalDateTime;

import com.example.bankpoc.models.enums.TypeTransfer;
import com.example.bankpoc.util.DateHour;

public class TransferResponse {

    private String typeTransfer;
    private Long accountIdDesposit;
    private Long accountIdRecipient;
    private double value;
    private LocalDateTime date;

    public TransferResponse(Long accountIdDesposit, Long accountIdRecipient, double value, LocalDateTime date, TypeTransfer typeTransfer) {
        this.typeTransfer = typeTransfer.name();
        this.accountIdDesposit = accountIdDesposit;
        this.accountIdRecipient = accountIdRecipient;
        this.value = value;
        this.date = date;
    }

    public String getTypeTransfer() {
        return typeTransfer;
    }

    public void setTypeTransfer(String typeTransfer) {
        this.typeTransfer = typeTransfer;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
