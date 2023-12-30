package com.example.BankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagement.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Double>{

}
