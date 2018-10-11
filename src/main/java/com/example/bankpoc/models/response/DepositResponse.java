package com.example.bankpoc.models.response;

import java.time.LocalDateTime;

public class DepositResponse {

    private Long accountId;
    private double value;
    private LocalDateTime date;
    private String transferType;

    public DepositResponse(Long accountId, double value, LocalDateTime date, String transferType) {
        this.accountId = accountId;
        this.value = value;
        this.date = date;
        this.transferType = transferType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "DepositResponse{" +
                "accountId=" + accountId +
                ", value=" + value +
                ", date=" + date +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
