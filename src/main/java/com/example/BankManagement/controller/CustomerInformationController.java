package com.example.BankManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagement.dto.CustomerInformationDTO;
import com.example.BankManagement.entity.CustomerInformation;
import com.example.BankManagement.exception.BusinessException;
import com.example.BankManagement.service.CustomerInformationServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomerInformationController {
	
	@Autowired
	private CustomerInformationServiceImpl customerService;
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Object> saveCustomer(@RequestBody CustomerInformationDTO customerInformationDTO){
		
		try {
			CustomerInformationDTO cutomerInformationDTO = customerService.createCustomer(customerInformationDTO);
			return new ResponseEntity<Object>(cutomerInformationDTO, HttpStatus.CREATED);
			
		}catch (BusinessException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	@GetMapping("/findCustomer/{id}")
	public ResponseEntity<CustomerInformation> findCustomerById(@PathVariable Long customerId){
		CustomerInformation customerInformation = new CustomerInformation();
		try {
		customerInformation	= customerService.findById(customerId);
		return new ResponseEntity<CustomerInformation>(customerInformation, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<CustomerInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findAllCustomer")
	public ResponseEntity<List<CustomerInformationDTO>> findAll(){
		try {
			List<CustomerInformationDTO> listCustomerInformation = new ArrayList<>();
			listCustomerInformation = customerService.findAllCustomer();
			return new ResponseEntity<List<CustomerInformationDTO>>(listCustomerInformation, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<CustomerInformationDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
