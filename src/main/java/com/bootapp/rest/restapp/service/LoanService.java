package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.LoanRepository;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Loan;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository; 
	
	public Optional<Loan> getLoanById(int id) {
		Optional<Loan> optional = loanRepository.findById(id);
		return optional;
	}

	public List<Loan> getAllLoan() {
		List<Loan> list = loanRepository.findAll();
		return list;
	}

	public void postLoan(Loan loan) {
		loanRepository.save(loan);
	}

	public Optional<Loan> findById(int id) {
		Optional<Loan> optional = loanRepository.findById(id);
		return optional;
	}

}
