package com.example.BankManagement.entity;

import java.io.Serializable;
import java.util.List;

import com.example.BankManagement.dto.AccountDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "CUSTOMERINFORMATION")
public class CustomerInformation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMERID")
	private long customerId;
	
	@Column(name = "FIRSTNAME")
    private String firstName;
	
	@Column(name = "LASTNAME")
    private String lastName;
	
	@Column(name = "PHONENUMBER")
    private String phoneNumber;
	
	@Column(name = "EMAIL")
    private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Account> accountList;
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name = "id")
    private Address address;
	
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

	
	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
