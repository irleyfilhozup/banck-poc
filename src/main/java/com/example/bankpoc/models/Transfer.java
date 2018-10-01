package com.example.bankpoc.models;



import com.example.bankpoc.util.DateHour;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tomcat.jni.Time;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private Integer id_account_source;
	private Integer id_destination_account;
	private double value;
	private Timestamp date;
	
	public Transfer(Integer id_account_source, Integer id_destination_account, double value, Timestamp date) {
		this.id_account_source = id_account_source;
		this.id_destination_account = id_destination_account;
		this.value = value;
		this.date = date;
	}

	public Transfer(Integer id_destination_account, double value, Timestamp date) {
		this.id_account_source = 1;
		this.id_destination_account = id_destination_account;
		this.value = value;
		this.date = date;
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
	
	@Override
	public String toString() {
		return "Transação numero: " + this.id + ".\n" +
			   "Id Depositante: " + this.id_account_source + ".\n" +
			   "Id Beneficiario: " + this.id_destination_account + ".\n" +
			   "Valor Transferencia: " + this.value + ".\n" +
			   "Data Transferencia: " + DateHour.getDate(this.date) + ".\n";
	}
}
