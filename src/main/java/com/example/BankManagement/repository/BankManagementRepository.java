package com.example.BankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagement.entity.CustomerInformation;

@Repository
public interface BankManagementRepository extends JpaRepository<CustomerInformation,Long>{

}
