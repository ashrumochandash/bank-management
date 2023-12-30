package com.example.BankManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagement.dto.AccountDTO;
import com.example.BankManagement.entity.Account;
import com.example.BankManagement.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public String createAccount(AccountDTO account) {
		
		Account acco = new Account();
		
		return null;
	}

}
