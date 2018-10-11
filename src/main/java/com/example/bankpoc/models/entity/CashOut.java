package com.example.bankpoc.models.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.bankpoc.models.enums.TypeTransfer;

@Entity
public class CashOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private double value;
    private LocalDateTime date;
    private String transferType;

    public CashOut(){}

    public CashOut(Long accountId, double value) {
        this.accountId = accountId;
        this.value = value;
        this.date = LocalDateTime.now();
        this.transferType = TypeTransfer.CASHOUT.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "CashOut{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", value=" + value +
                ", date=" + date +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
