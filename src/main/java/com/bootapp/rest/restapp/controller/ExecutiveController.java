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

import com.bootapp.rest.restapp.model.Executive;
import com.bootapp.rest.restapp.service.ExecutiveService;

@RestController
@RequestMapping("/api/executives")
public class ExecutiveController {
	@Autowired
	private ExecutiveService executiveService;
	/* Executive OOST Api */

	@PostMapping("/add")
	public ResponseEntity<String> postExecutive(@RequestBody Executive executive) {
		executiveService.insertExecutive(executive);
		return ResponseEntity.status(HttpStatus.OK).body("Executive Added in Banking");
	}

	/* Get all Api */
	@GetMapping("/getall")
	public List<Executive> getAllExecutive() {
		List<Executive> list = executiveService.getAllExecutive();
		return list;
	}

	/* GEt by id */
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getExecutiveById(@PathVariable("id") int id) {
		Optional<Executive> optional = executiveService.getExecutiveById(id);
		if (optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");

		Executive executive = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(executive);
	}

}

