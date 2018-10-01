package com.example.bankpoc.models;



import com.example.bankpoc.exception.InvalidValueException;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Timestamp date_creation;
	private double balance;

	public Account() {}

	public Account(Timestamp date_creation) {
		this.date_creation = date_creation;
		this.balance = 0;		
	}
	
	public Account(Timestamp date_creation, double balance) {
		this.date_creation = date_creation;
		this.balance = balance;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public Date getDate_creation() {
		return date_creation;
	}	
	
	public void deposit(double value) {
		if(value <= 0) {
			throw new InvalidValueException(value);
		}
		this.balance += value;
	}
	
	public void toWithdraw(double value) {
		this.balance -= value;
	}
}
