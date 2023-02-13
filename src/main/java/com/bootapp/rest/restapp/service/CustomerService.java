package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;
import com.bootapp.rest.restapp.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Loan;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository; 
	
	public void postCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerById(int cid) {
		Optional<Customer> optional = customerRepository.findById(cid);
		//If department exists, optional will not be null
		if(optional != null)
			return optional.get();//returning the department
		//If department does not exist,optional will be null
		
		return null;
	}
	

	public List<Customer> getAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	
//	public Optional<Customer> updateById(long id) {
//		 customerRepository.save(id);
//		return null;
//	}

	public void deleteById(int customerId) {
		customerRepository.deleteById(customerId);
	}

	public Optional<Customer> findById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		return optional;
	}

	
//
//	public List<Customer> getCustomersByLoanId(int lid) {
//		// TODO Auto-generated method stub
//				List<Customer> list = customerRepository.findAll();
//				List<Customer> filteredList = list.stream().filter(e->e.getLoan().getLoan_Id() == lid).collect(Collectors.toList());
//				return filteredList;
//	}

	
}