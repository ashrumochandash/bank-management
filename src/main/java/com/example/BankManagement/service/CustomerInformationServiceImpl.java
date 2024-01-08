package com.example.BankManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagement.dto.AccountDTO;
import com.example.BankManagement.dto.AddressDTO;
import com.example.BankManagement.dto.CustomerInformationDTO;
import com.example.BankManagement.entity.Account;
import com.example.BankManagement.entity.AccountPk;
import com.example.BankManagement.entity.Address;
import com.example.BankManagement.entity.Bank;
import com.example.BankManagement.entity.CustomerInformation;
import com.example.BankManagement.exception.BusinessException;
import com.example.BankManagement.repository.BankManagementRepository;
import com.example.BankManagement.repository.BankRepository;

@Service
public class CustomerInformationServiceImpl implements CustomerInformationService{
	
	@Autowired
	private BankManagementRepository bankRepository;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public CustomerInformationDTO createCustomer(CustomerInformationDTO customerInfoDTO) {
		createCustomerValidation(customerInfoDTO);
		List<Bank> bankList = new ArrayList<Bank>();
		bankList = bankRepo.findAll();
	
		CustomerInformation customer = new CustomerInformation();
		customer.setFirstName(customerInfoDTO.getFirstName());
		customer.setLastName(customerInfoDTO.getLastName());
		customer.setPhoneNumber(customerInfoDTO.getPhoneNumber());
		customer.setEmail(customerInfoDTO.getEmail());
		
		Address address = populateAddress(customerInfoDTO.getAddress());
		customer.setAddress(address);
		
		List<Account> accountList = populateAccount(customerInfoDTO.getAccountDTOList(),bankList, customer);
		customer.setAccountList(accountList);
		
	    CustomerInformation customerInfo =  bankRepository.save(customer);
	    customerInfoDTO.setCustomerId(customerInfo.getCustomerId());
	    
	   
	    for(Account singleAccount: accountList) {
	         
	    	for(AccountDTO accountDTO: customerInfoDTO.getAccountDTOList()) {
	    		if(singleAccount.getAccountPk().getAccountNumber() == accountDTO.getAccountNumber()) {
	    			accountDTO.setBalance(singleAccount.getBalance());
	    			accountDTO.setBankName(singleAccount.getBank().getBankName());
	    			break;
	    		}
	    	}
	    	
		}
	    return customerInfoDTO;
	}
	
	private Address populateAddress(AddressDTO addressDTO) {
		Address address = new Address();
		address.setAddress1(addressDTO.getAddress1());
		address.setAddress2(addressDTO.getAddress2());
		address.setZip(addressDTO.getZip());
		return address;
	}
	
	private List<Account> populateAccount(List<AccountDTO> accountDTOList,List<Bank> bankList, CustomerInformation customer)throws BusinessException {
		List<Account> accountList = new ArrayList<>();
		
		for(AccountDTO accountDTO: accountDTOList) {
			Account account = new Account();
			String stringAccount = String.valueOf(accountDTO.getAccountNumber());
			String subString = stringAccount.substring(0,4);
			long convertedAccount = Long.valueOf(subString);
			boolean isPatternCheak = false;
			
			for(Bank bank: bankList) {
				if(convertedAccount == bank.getAccountPattern()) {
					isPatternCheak = true;
					account.setBank(bank);
				}
			}
			
			if(!isPatternCheak) {
				throw new BusinessException("Sorry we can n't find your account is attached with any bank!!");
			}
			AccountPk accountPk = new AccountPk();
			accountPk.setAccountNumber(accountDTO.getAccountNumber());
			accountPk.setAccountType(accountDTO.getAccountType());
			
			account.setAccountPk(accountPk);
			account.setCustomer(customer);
			
			accountList.add(account);
				
		}
		return accountList;	
	}
	private void createCustomerValidation(CustomerInformationDTO customerInformationDTO)throws BusinessException{
		if(StringUtils.isBlank(customerInformationDTO.getFirstName())) {
			throw new BusinessException("First Name field can not be empty!!");
		}
		
		if(StringUtils.isBlank(customerInformationDTO.getLastName())) {
			throw new BusinessException("Last Name field can not be empty!!");
		}
		
		if(StringUtils.isBlank(customerInformationDTO.getPhoneNumber())) {
			throw new BusinessException("Phone Number Can not be Blank!!");
		}else {
			if(customerInformationDTO.getPhoneNumber().length()>=10) {
				if(!customerInformationDTO.getPhoneNumber().startsWith("0") && !customerInformationDTO.getPhoneNumber().startsWith("27")) {
					throw new BusinessException("Phon Number is not Valid number!!");
				}
			}else {
				throw new BusinessException("Phone Number can not be Less then 10!!");
			}
		}
		if(StringUtils.isBlank(customerInformationDTO.getEmail())) {
			throw new BusinessException("Email field can not be empty!!");
		}else {
			String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; 
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customerInformationDTO.getEmail());
			if(!matcher.matches()) {
				throw new BusinessException("Email address not valid!!");
			}
		}
		
	}
	@Override
	public CustomerInformation findById(long customerId) {
		return bankRepository.findById(customerId).orElse(null);
	}

	@Override
	public String deleteCustomerById(long customerId) {
		bankRepository.deleteById(customerId);
		return "Customer removed !! "+ customerId;
	}

	@Override
	public String updateCustomerById(long customerId) {
		
		return null;
	}

	@Override
	public List<CustomerInformationDTO> findAllCustomer() {
		List<CustomerInformation> customerInfoList = new ArrayList<CustomerInformation>();
		customerInfoList = bankRepository.findAll();
		List<CustomerInformationDTO> customerInfoDtoList = new ArrayList<CustomerInformationDTO>();
		for(CustomerInformation customerInfo : customerInfoList) {
			CustomerInformationDTO customerInfoDto = new CustomerInformationDTO();
			customerInfoDto.setCustomerId(customerInfo.getCustomerId());
			customerInfoDto.setFirstName(customerInfo.getFirstName());
			customerInfoDto.setLastName(customerInfo.getLastName());
			customerInfoDto.setPhoneNumber(customerInfo.getPhoneNumber());
			customerInfoDto.setEmail(customerInfo.getEmail());
			List<AccountDTO> accountList = AccountList();
			customerInfoDto.setAccountDTOList(accountList);
			AddressDTO addressDto = setAddress();
			customerInfoDto.setAddress(addressDto);
			customerInfoDtoList.add(customerInfoDto);
		}
		return customerInfoDtoList;
	}

	private AddressDTO setAddress() {
		AddressDTO addressDTO = new AddressDTO();
		Address address = new Address();
		addressDTO.setAddress1(address.getAddress1());
		addressDTO.setAddress2(address.getAddress2());
		addressDTO.setZip(address.getZip());
		return addressDTO;
	}

	private List<AccountDTO> AccountList() {
		List<AccountDTO> accountDtoList = new ArrayList<AccountDTO>();
		List<Account> accountList = new ArrayList<Account>();
		for(Account account: accountList) {
			AccountDTO accountDto = new AccountDTO();
			accountDto.setAccountNumber(account.getAccountPk().getAccountNumber());
			accountDto.setAccountType(account.getAccountPk().getAccountType());
			accountDto.setBalance(account.getBalance());
			accountDto.setBankName(account.getBank().getBankName());
			accountDtoList.add(accountDto);
		}
		return accountDtoList;
	}
}
