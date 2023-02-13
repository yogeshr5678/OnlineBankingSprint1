package com.bootapp.rest.restapp.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.data.LoanRepository;
import com.bootapp.rest.restapp.exception.ResourceNotFoundException;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Loan;
import com.bootapp.rest.restapp.service.CustomerService;
import com.bootapp.rest.restapp.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoanRepository loanRepository;


	@PostMapping("/add/{cid}")
	public ResponseEntity<String> postLoan(@RequestBody Loan loan,@PathVariable("cid")int cid ) {
		
		Customer customer = customerService.getCustomerById(cid);
		loan.setCustomer(customer);
		loan.setStartDate(LocalDate.now());
		loanService.postLoan(loan);
		
		return ResponseEntity.status(HttpStatus.OK).body("Loan added ...");
		
	}
	
	@GetMapping("/getall")
	public List<Loan> getAllLoan() {
		List<Loan> list = loanService.getAllLoan();
		return list;
	}
	
	@PutMapping("/edit/{lid}")
	public ResponseEntity<String> editEMployee(@PathVariable("lid") int lid, 
							@RequestBody Loan loanNew) {
//		 Step 1: check if this id given is valid by fetching the record from DB
		Optional<Loan> optional = loanService.getLoanById(lid);
		
		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}
		
		Loan loanDB = optional.get(); //User given loan value
		
		/* Step 2: Set New value to DB value */
		if(loanNew.getAmount() != 0.0)
			loanDB.setAmount(loanNew.getAmount());
		if(loanNew.getStartDate()!= null)
			loanDB.setStartDate(loanNew.getStartDate());
		if(loanNew.getType() != null)
			loanDB.setType(loanNew.getType());
		if(loanNew.getLoan() != null)
			loanDB.setLoan(loanNew.getLoan());
		
		/* Save updated LoanDB value in DB */
		loanService.postLoan(loanDB);
		return ResponseEntity.status(HttpStatus.OK).body("Loan record Edited..");
		
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getLoanById(@PathVariable("id")int id) {
		Optional<Loan> optional = loanService.getLoanById(id);
		
		if(optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
		
		Loan loan = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(loan);
	}
	

	@GetMapping("/customer/{lid}")
	public List<Loan> showCustomersByLoanId(@PathVariable("lid") int lid) {
		List<Loan> list = loanService.getCustomersByLoanId(lid);
		return list;
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteLoan(@PathVariable int id) throws ResourceNotFoundException {
		Loan loan = loanService.getLoanById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

		loanService.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
}