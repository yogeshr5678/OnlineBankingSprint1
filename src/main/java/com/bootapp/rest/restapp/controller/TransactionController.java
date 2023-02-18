package com.bootapp.rest.restapp.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Transaction;
import com.bootapp.rest.restapp.service.TransactionService;


@CrossOrigin(origins = {"*"})
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	// addLog
	public void addLog(Transaction transaction) {
		transaction.setTransaction_date(LocalDate.now());
		transaction.setTransaction_time(LocalTime.now());
		transactionService.addLog(transaction);
	}

	// showLog
	@GetMapping("/account/{acctID}/logs")
	public Transaction showLog(@PathVariable int acctID) {
		return transactionService.showLog(acctID);
	}

	public void deleteLog(int acctID) {
		transactionService.deleteLog(acctID);
	}
}
