package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.TransactionRepository;
import com.bootapp.rest.restapp.model.Transaction;




@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	public void addLog(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public Transaction showLog(int acctID) {
		return transactionRepository.findById(acctID).orElse(null);
	}

	public void deleteLog(int acctID) {
		transactionRepository.deleteById(acctID);
	}
}
