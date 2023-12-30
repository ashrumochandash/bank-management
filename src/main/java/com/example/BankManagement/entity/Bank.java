package com.example.BankManagement.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank implements Serializable {
	
	@Id
	@Column(name ="BANKID")
	private long bankId;
	@Column(name = "BANKNAME")
	private String bankName;
	@Column(name = "IFSCCODE")
	private String ifscCode;
	@Column(name = "ACCOUNTPATTERN")
	private long accountPattern;
	
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public long getAccountPattern() {
		return accountPattern;
	}
	public void setAccountPattern(long accountPattern) {
		this.accountPattern = accountPattern;
	}
}
