package com.example.BankManagement.service;

import java.util.List;

import com.example.BankManagement.dto.CustomerInformationDTO;
import com.example.BankManagement.entity.Bank;
import com.example.BankManagement.entity.CustomerInformation;

public interface CustomerInformationService {
	
	public CustomerInformationDTO createCustomer(CustomerInformationDTO customerInfo);
	public CustomerInformation findById(long customerId);
	public String deleteCustomerById(long customerId);
	public String updateCustomerById(long customerId);
	public List<CustomerInformationDTO> findAllCustomer();
}
