package com.bootapp.rest.restapp.controller;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Account;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Transaction;
import com.bootapp.rest.restapp.service.AccountService;
import com.bootapp.rest.restapp.service.CustomerService;


@CrossOrigin(origins = {"*"})
@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TransactionController transactionController;
	

	// createAccount happens upon createCustomer
//	public void createAccount(int acctID, int balance, String acctStatus) {
//		Account acct = new Account(acctID, balance, acctStatus);
//		accountService.createAccount(acct);
//	}
	

	@PostMapping("/account/add/{cid}")
	public ResponseEntity<String> postAccount(@RequestBody Account account,@PathVariable("cid")int cid ) {
		
		Customer customer = customerService.getCustomerById(cid);
		account.setCustomer(customer);
		account.setStartDate(LocalDate.now());
		accountService.postAccount(account);
		
		return ResponseEntity.status(HttpStatus.OK).body("Account added ...");
		
	}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public Double getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/deposit/{acctID}/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		Double initBal = getBalance(acctID);
		accountService.depositAmount(acctID, amount);
		Transaction transaction = new Transaction(acctID, "Deposited", "Success", initBal, initBal + amount);
		transactionController.addLog(transaction);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		Double initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Transaction transaction = new Transaction(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		transactionController.addLog(transaction);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		
		Double initBalSender = getBalance(acctID);
		Double initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Transaction transactionSender = new Transaction(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		transactionController.addLog(transactionSender);
		Transaction loggerReceiver = new Transaction(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		transactionController.addLog(loggerReceiver);
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountService.deleteAccount(acctID);
		transactionController.deleteLog(acctID);
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Account getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}

}