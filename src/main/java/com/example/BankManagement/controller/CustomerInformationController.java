package com.example.BankManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> findCustomerById(@PathVariable long id){
		CustomerInformationDTO customerInformationDTO = new CustomerInformationDTO();
		try {
		customerInformationDTO	= customerService.findById(id);
		return new ResponseEntity<CustomerInformationDTO>(customerInformationDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Unable to fetch the Record's",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findAllCustomer")
	public ResponseEntity<?> findAll(){
		try {
			List<CustomerInformationDTO> listCustomerInformation = new ArrayList<>();
			listCustomerInformation = customerService.findAllCustomer();
			return new ResponseEntity<List<CustomerInformationDTO>>(listCustomerInformation, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Unable to fetch the Record's",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		try {
			customerService.deleteCustomerById(id);
			return new ResponseEntity<String>("Your Data is Deleted", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Your data is not Deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerInformationDTO customerInformationDTO,
			@PathVariable long id){
		try {
			CustomerInformationDTO customerInfoDTO = customerService.findById(id);
			if (customerInfoDTO != null) {
				customerService.updateCustomer(customerInformationDTO, id);
				return new ResponseEntity<String>("Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Requested Entity Does not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to Upadate the Record's", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
