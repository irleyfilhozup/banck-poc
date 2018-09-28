package com.example.bankpoc.models;



import com.example.bankpoc.exception.InvalidValueException;

import java.sql.Date;

public class Account {

	private Integer id;
	private Date date_creation;
	private double balance;
	
	public Account(Date date_creation) {
		this.date_creation = date_creation;
		this.balance = 0;		
	}
	
	public Account(Date date_creation, double balance) {
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
