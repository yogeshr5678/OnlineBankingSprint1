package com.bootapp.rest.restapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bootapp.rest.restapp.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@Autowired
	private LoanRepository loanRepository;


	@PostMapping("/add")
	public ResponseEntity<String> postLoan(@RequestBody Loan loan) {
		loanService.postLoan(loan);
		loan.setStartDate(LocalDate.now());
		return ResponseEntity.status(HttpStatus.OK).body("Loan added ...");
	}

	@GetMapping("/getall")
	public List<Loan> getAllLoan() {
		List<Loan> list = loanService.getAllLoan();
		return list;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getLoanById(@PathVariable("id") int id) {
		Optional<Loan> optional = loanService.getLoanById(id);
		if (optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id given");
		
		Loan loan = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(loan);
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Loan> updateloan(@PathVariable int id,@RequestBody Loan loanDetails)throws ResourceNotFoundException{
        Loan loan = loanService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not exist with id: " + id));

        loan.setType(loanDetails.getType());
        loan.setAmount(loanDetails.getAmount());
        loan.setLoan(loanDetails.getLoan());

        final Loan updatedLoan = loanRepository.save(loan);
        return ResponseEntity.ok(updatedLoan);
    }
	
	
}
	
