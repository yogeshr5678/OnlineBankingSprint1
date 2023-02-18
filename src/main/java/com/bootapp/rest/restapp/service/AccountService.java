package com.bootapp.rest.restapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.AccountRepository;
import com.bootapp.rest.restapp.model.Account;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public void createAccount(Account acct) {
		accountRepository.save(acct);
	}

	public Account getAccountInfo(int acctID) {
		return accountRepository.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public Double getBalance(int acctID) {
		Optional<Account> account = accountRepository.findById(acctID);
		if (account.isPresent()) {
			return account.get().getBalance();
		} else {
			return null;
		}

	}

	public void depositAmount(int acctID, int amount) {
//		accountRepository.saveBalanceByAcctID(acctID, amount);
		Optional<Account> account = accountRepository.findById(acctID);
		if (account.isPresent()) {
			Account acct = account.get();
			acct.setBalance(acct.getBalance() + amount);
			accountRepository.save(acct);
		}
	}

	public void withdrawAmount(int acctID, int amount) {
//		accountRepository.withdrawAmountByAcctID(acctID, amount);
		Optional<Account> account = accountRepository.findById(acctID);
		if (account.isPresent()) {
			Account acct = account.get();
			if (acct.getBalance() >= amount) {
				acct.setBalance(acct.getBalance() - amount);
				accountRepository.save(acct);
			} else {
				//
			}
		}
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		Optional<Account> sourceAccountOptional = accountRepository.findById(acctID);
		Optional<Account> destinationAccountOptional = accountRepository.findById(destAcctID);

		if (!sourceAccountOptional.isPresent() || !destinationAccountOptional.isPresent()) {
			throw new RuntimeException("Source or destination account not found");
		}

		Account sourceAccount = sourceAccountOptional.get();
		Account destinationAccount = destinationAccountOptional.get();

		if (sourceAccount.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance in the source account ");
		}
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		destinationAccount.setBalance(destinationAccount.getBalance() + amount);

		accountRepository.save(sourceAccount);
		accountRepository.save(destinationAccount);

	}

	public void postAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);

	}

}