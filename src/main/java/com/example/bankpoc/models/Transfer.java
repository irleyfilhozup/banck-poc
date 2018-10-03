package com.example.bankpoc.models;



import com.example.bankpoc.util.DateHour;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.apache.tomcat.jni.Time;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer id_account_source;
	private Integer id_destination_account;

	@Min(value = 0l)
	private double value;
	private Timestamp date;
    private String type_transfer;

	public Transfer(){}
	
	public Transfer(Integer id_account_source, Integer id_destination_account, double value, Timestamp date,
			TypeTransfer type_transfer) {
		this.id_account_source = id_account_source;
		this.id_destination_account = id_destination_account;
		this.value = value;
		this.date = date;
		this.type_transfer = type_transfer.name();
	}

	public Transfer(Integer id_destination_account, double value, Timestamp date, TypeTransfer type_transfer) {
		this.id_account_source = 1;
		this.id_destination_account = id_destination_account;
		this.value = value;
		this.date = date;
		this.type_transfer = type_transfer.name();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId_account_source() {
		return id_account_source;
	}
	
	public void setId_account_source(Integer id_account_source) {
		this.id_account_source = id_account_source;
	}
	
	public Integer getId_destination_account() {
		return id_destination_account;
	}
	
	public void setId_destination_account(Integer id_destination_account) {
		this.id_destination_account = id_destination_account;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
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
		return "Transação numero: " + this.id + ".\n" +
			   "Id Depositante: " + this.id_account_source + ".\n" +
			   "Id Beneficiario: " + this.id_destination_account + ".\n" +
			   "Valor Transferencia: " + this.value + ".\n" +
			   "Data Transferencia: " + DateHour.getDate(this.date) + ".\n" +
               "Tipo Transação: " + this.type_transfer+".\n";
	}
}
