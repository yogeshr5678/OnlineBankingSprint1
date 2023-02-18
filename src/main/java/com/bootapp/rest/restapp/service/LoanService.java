package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;
import com.bootapp.rest.restapp.data.LoanRepository;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Loan;


@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository; 

	@Autowired
	private CustomerRepository customerRepository; 

	public void postLoan(Loan loan) {
		// save loan in DB 
		loanRepository.save(loan);

	}

	public List<Loan> getCustomersByLoanId(int cid) {
		List<Loan> list = loanRepository.findAll();
		List<Loan> filteredList = list.stream().filter(e->e.getLoan_Id() == cid).collect(Collectors.toList());
		return filteredList;// TODO Auto-generated method stub
	}

	public List<Loan> getAllLoan() {
		List<Loan> list = loanRepository.findAll();
		return list;

	}

	public Object findById(int id) {
		Optional<Loan> optional = loanRepository.findById(id);
		return optional;	}

	public Optional<Loan> getLoanById(int lid) {
		return loanRepository.findById(lid);
	}

	public void deleteById(int id) {
		loanRepository.deleteById(id);		
	}
	
	
	
//	public List<Loan> getCustomersByLoanId(int cid) {
//		List<Loan> list = loanRepository.findAll();
//		List<Loan> filteredList = list.stream().filter(e->e.getCustomer().getId() == cid).collect(Collectors.toList());
//		return filteredList;
//	}




}
