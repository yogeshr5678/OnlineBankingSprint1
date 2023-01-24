package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;
import com.bootapp.rest.restapp.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository; 
	
	public void postCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		return optional;
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

	
}
