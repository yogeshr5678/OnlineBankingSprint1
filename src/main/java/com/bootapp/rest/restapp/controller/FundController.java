package com.bootapp.rest.restapp.controller;

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

import com.bootapp.rest.restapp.data.FundRepository;
import com.bootapp.rest.restapp.exception.ResourceNotFoundException;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Fund;
import com.bootapp.rest.restapp.service.FundService;

@RestController
@RequestMapping("/api/funds")
public class FundController {
	@Autowired
	private FundService fundService;
	
	@Autowired 
	private FundRepository fundRepository;

	@PostMapping("/add")
	public ResponseEntity<String> postFund(@RequestBody Fund fund) {
		fundService.postFund(fund);
		return ResponseEntity.status(HttpStatus.OK).body("fund added in DB");
	}

	@GetMapping("/getall")
	public List<Fund> getAllFunds() {
		List<Fund> list = fundService.getAllFunds();
		return list;

	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getFundById(@PathVariable("id") int id) {
		Optional<Fund> optional = fundService.getFundById(id);
		if (optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		Fund fund = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(fund);
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Fund> updateFund(@PathVariable int id,@RequestBody Fund fundDetails)throws ResourceNotFoundException{
        Fund fund = fundService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fund not exist with id: " + id));

        fund.setCompany_name(fundDetails.getCompany_name());
        fund.setSip_amount(fundDetails.getSip_amount());
        fund.setYears(fundDetails.getYears());
        fund.setInterest(fundDetails.getInterest());
        fund.setBalance(fundDetails.getBalance());

        final Fund updatedFund = fundRepository.save(fund);
        return ResponseEntity.ok(updatedFund);
    }
	
	@DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteFund(@PathVariable int id)
         throws ResourceNotFoundException {
        Fund fund = fundService.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Fund not found for this id :: " + id));

        fundService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}