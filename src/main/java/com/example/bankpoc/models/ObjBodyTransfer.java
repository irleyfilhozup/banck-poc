package com.example.bankpoc.models;

public class ObjBodyTransfer {

    private Integer idRecipient;
    private Integer idDeposit;
    private double value;

    public ObjBodyTransfer(){}

    public ObjBodyTransfer(Integer idRecipient, Integer idDeposit, double value) {
        this.idRecipient = idRecipient;
        this.idDeposit = idDeposit;
        this.value = value;
    }

    public Integer getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(Integer idRecipient) {
        this.idRecipient = idRecipient;
    }

    public Integer getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(Integer idDeposit) {
        this.idDeposit = idDeposit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
