package com.example.bankpoc.models.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.bankpoc.models.enums.TypeTransfer;
import com.example.bankpoc.models.request.DepositRequest;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_account;
    private double value;
    private LocalDateTime date;
    private String type_transfer;

    public Deposit(){}

    public Deposit(DepositRequest depositRequest) {
        this.id_account = depositRequest.getAccountId();
        this.value = depositRequest.getValue();
        this.date = LocalDateTime.now();
        this.type_transfer = TypeTransfer.DEPOSIT.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_account() {
        return id_account;
    }

    public void setId_account(Long id_account) {
        this.id_account = id_account;
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

    public String getType_transfer() {
        return type_transfer;
    }

    public void setType_transfer(String type_transfer) {
        this.type_transfer = type_transfer;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", id_account=" + id_account +
                ", value=" + value +
                ", date=" + date +
                ", type_transfer='" + type_transfer + '\'' +
                '}';
    }
}
