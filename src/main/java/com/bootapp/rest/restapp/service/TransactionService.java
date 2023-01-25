package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.TransactionRepository;
import com.bootapp.rest.restapp.model.Transaction;

@Service
public class TransactionService {
	@Autowired
private TransactionRepository transactionRepository;

	public void postTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
      
}
}