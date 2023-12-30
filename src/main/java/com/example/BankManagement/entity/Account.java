package com.example.BankManagement.entity;
import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    
	@Column(name = "ACCOUNTPK")
	@EmbeddedId AccountPk accountPk;
	
	@Column(name = "BALANCE")
	private double balance;
	//woning side in bi-directional mapping
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private CustomerInformation customer;
	
	@Column(name = "BANKID")
	@PrimaryKeyJoinColumn(name = "bankId")
	private Bank bank;
	
	public AccountPk getAccountPk() {
		return accountPk;
	}
	public void setAccountPk(AccountPk accountPk) {
		this.accountPk = accountPk;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public CustomerInformation getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInformation customer) {
		this.customer = customer;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
