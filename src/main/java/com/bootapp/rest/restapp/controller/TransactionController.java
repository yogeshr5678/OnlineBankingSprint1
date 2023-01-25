package com.bootapp.rest.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootapp.rest.restapp.model.Transaction;
import com.bootapp.rest.restapp.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	/* Transaction POST api */

	@PostMapping("/add")
	public ResponseEntity<String> postTransaction(@RequestBody Transaction transaction) {
		transactionService.postTransaction(transaction);
		return ResponseEntity.status(HttpStatus.OK).body("Transaction posted in Banking");
	}
}