package com.example.bankpoc.models;

public class ObjBodyDepositCashOut {

    private Integer idClient;
    private double value;

    public ObjBodyDepositCashOut(){}

    public ObjBodyDepositCashOut(Integer idClient, double value) {
        this.idClient = idClient;
        this.value = value;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
