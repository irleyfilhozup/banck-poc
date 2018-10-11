package com.example.bankpoc.models.entity;

import com.example.bankpoc.models.enums.TypeTransfer;
import com.example.bankpoc.models.request.TransferRequest;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long accountIdDesposit;
	private Long accountIdRecipient;

    private String typeTransfer;
    private LocalDateTime date;

    @Min(value = 0l)
    private double value;

	public Transfer(){}
	
	public Transfer(TransferRequest transferRequest) {
		this.accountIdDesposit = transferRequest.getDepositAccountid();
		this.accountIdRecipient = transferRequest.getRecipientAccountid();
		this.value = transferRequest.getValue();
		this.date = LocalDateTime.now();
		this.typeTransfer = TypeTransfer.TRANSFER.name();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAccountIdDesposit() {
		return accountIdDesposit;
	}
	
	public void setAccountIdDesposit(Long accountIdDesposit) {
		this.accountIdDesposit = accountIdDesposit;
	}
	
	public Long getAccountIdRecipient() {
		return accountIdRecipient;
	}
	
	public void setAccountIdRecipient(Long accountIdRecipient) {
		this.accountIdRecipient = accountIdRecipient;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

    public String getTypeTransfer() {
        return typeTransfer;
    }

    public void setTypeTransfer(String typeTransfer) {
        this.typeTransfer = typeTransfer;
    }

	@Override
	public String toString() {
		return "Transfer{" +
				"id=" + id +
				", accountIdDesposit=" + accountIdDesposit +
				", accountIdRecipient=" + accountIdRecipient +
				", typeTransfer='" + typeTransfer + '\'' +
				", date=" + date +
				", value=" + value +
				'}';
	}
}
