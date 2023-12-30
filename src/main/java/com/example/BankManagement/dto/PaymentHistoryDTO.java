package com.example.BankManagement.dto;

import java.util.Date;

public class PaymentHistoryDTO {
	
	private long transactionId;
	private Date date;
	private double amount;
	private long sourceAccount;
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
