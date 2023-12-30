package com.example.BankManagement.dto;

import java.util.List;

public class CustomerInformationDTO {
	
	private long   customerId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private List<AccountDTO> accountDTOList;
	private AddressDTO address;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<AccountDTO> getAccountDTOList() {
		return accountDTOList;
	}
	public void setAccountDTOList(List<AccountDTO> accountDTOList) {
		this.accountDTOList = accountDTOList;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}
