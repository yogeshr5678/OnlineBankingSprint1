package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootapp.rest.restapp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	
}