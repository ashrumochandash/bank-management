package com.example.BankManagement.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class AccountPk implements Serializable{
   
	private long accountNumber;
	private String accountType;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
