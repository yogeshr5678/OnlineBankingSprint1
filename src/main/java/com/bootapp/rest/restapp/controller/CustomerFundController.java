//package com.bootapp.rest.restapp.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bootapp.rest.restapp.model.CustomerFund;
//import com.bootapp.rest.restapp.model.Customer;
//import com.bootapp.rest.restapp.model.Fund;
//import com.bootapp.rest.restapp.service.CustomerFundService;
//import com.bootapp.rest.restapp.service.CustomerService;
//import com.bootapp.rest.restapp.service.FundService;
//
//@RestController
//@RequestMapping("/api/customer/fund")
//public class CustomerFundController {
//	
//	@Autowired
//	private FundService fundService;
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private CustomerFundService customerFundService;
//	
//	@PostMapping("/add/{customerId}/{fundId}")
//	public ResponseEntity<String> CustomerFund(@RequestBody CustomerFund customerFund ,@PathVariable("customerId") int customerId,
//			@PathVariable("fundId") int fundId ){
//		
//		Optional<Customer> optionalC = customerService.getCustomerById(customerId);
//		if(!optionalC.isPresent())
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid CoustmerId is given");
//		
//
//		Optional<Fund> optionalF = fundService.getFundById(fundId);
//		if(!optionalF.isPresent())
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid FundId is given");
//		
//		Customer customer = optionalC.get();
//	    Fund fund = optionalF.get();
//	    
//	    customerFund.setCustomer(customer);
//	    customerFund.setFund(fund);
//	    
//	    customerFundService.insert(customerFund);
//	    
//	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fund confirmed or assigned ");
//	    
//		
//	}
//
//	
//	
//}