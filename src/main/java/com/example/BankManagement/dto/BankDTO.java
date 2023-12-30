package com.example.BankManagement.dto;

public class BankDTO {

	private long bankId;
	private String bankName;
	private String ifsccode;
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
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public long getAccountPattern() {
		return accountPattern;
	}
	public void setAccountPattern(long accountPattern) {
		this.accountPattern = accountPattern;
	}
}
