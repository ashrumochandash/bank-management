package com.example.BankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagement.entity.PaymentHistory;

@Repository
public interface PaymentsHistoryRepository extends JpaRepository<PaymentHistory,Long>{

}
