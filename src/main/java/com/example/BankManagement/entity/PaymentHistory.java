package com.example.BankManagement.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENTHISTORY")
public class PaymentHistory implements Serializable{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTIONID")
	private long transactionId;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "AMOUNT")
	private double amount;
	@Column(name = "SOURCEACCOUNT")
	private long sourceAccount;
	@Column(name = "TARGETACCOUNT")
	private long targetAccount;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public long getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(long targetAccount) {
		this.targetAccount = targetAccount;
	}
}
