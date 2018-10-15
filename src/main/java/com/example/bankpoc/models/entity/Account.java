package com.example.bankpoc.models.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.bankpoc.exception.BusinessException;
import com.example.bankpoc.exception.client.InvalidValueException;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE_CREATION")
    private LocalDateTime createdAt;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public Account() {
    }

    public Account(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.balance = 0;
    }

    public Account(LocalDateTime createdAt, double balance) {
        this.createdAt = createdAt;
        this.balance = balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void deposit(double value) {
        if (value <= 0) {
            throw new BusinessException("VALOR_INVALIDO","Valor invalido para deposito");
        }
        this.balance += value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                '}';
    }

    public void cashOut(double value) {
        this.balance -= value;
    }
}
