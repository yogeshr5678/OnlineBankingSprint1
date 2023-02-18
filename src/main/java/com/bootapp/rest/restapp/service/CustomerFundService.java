package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerFundRepository;
import com.bootapp.rest.restapp.model.CustomerFund;

@Service
public class CustomerFundService {
	 @Autowired
	   private CustomerFundRepository customerFundRepository;

	public void insert(CustomerFund customerFund) {
		
		customerFundRepository.save(customerFund);
		
		
		
	  
	   
	   
		
	}

}
