package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.AccountRepository;
import com.bootapp.rest.restapp.model.Account;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Executive;

@Service
public class AccountService {
	@Autowired
	
	private AccountRepository accountRepository;
	
	public void insert (Account account) {
		accountRepository.save(account);
	}
	public void deleteId(int accountId) {
		accountRepository.deleteById(accountId);
	}

	public Optional<Account> findById(int id) {
		Optional<Account> optional = accountRepository.findById(id);
		return optional;
	}
	
	public List<Account> getAccountByExecutiveId(int eid){
		   List<Account> list = accountRepository.findAll();
		   List<Account> filteredList=list.stream()
				   .filter(e->e.getExecutive().getId()==eid)
		            .collect(Collectors.toList());
		return filteredList;
		   }
}
