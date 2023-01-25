package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Fund;
import com.bootapp.rest.restapp.service.FundService;

@RestController
@RequestMapping("/api/funds")
public class FundController {
	@Autowired
	private FundService fundService;

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

}
