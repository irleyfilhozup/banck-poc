package com.example.bankpoc.models;



import com.example.bankpoc.util.DateHour;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Client {

	@Id
	private Integer id;
	private Integer id_account;
	private String name;
	private String cpf;
	private Date date_creation;

	public Client(){

	}
	
	public Client(String name, String cpf, Date date_creation) {
		
		this.name = name;
		this.cpf = cpf;
		this.date_creation = date_creation;
	}	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_account() {
		return id_account;
	}
	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.name + ".\n" +
			   "Conta: " + acconutCompleted() + ".\n" +
			   "Cpf: " + this.cpf + ".\n" +
			   "Cliente desde: " + DateHour.getDate(this.date_creation) + ".";
	}
	
	private String acconutCompleted() {
		if(this.id_account==null) {
			return "nenhuma conta para o cliente";
		}
		return ""+this.id_account;
	}
	
	

}
