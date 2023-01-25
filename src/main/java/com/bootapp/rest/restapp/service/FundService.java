package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.FundRepository;
import com.bootapp.rest.restapp.model.Fund;
@Service
public class FundService {
	
	@Autowired
	private FundRepository fundRepository;

	public void postFund(Fund fund) {
		fundRepository.save(fund);
		
		
	}

	public List<Fund> getAllFunds() {
		
		return fundRepository.findAll();
	}

	public Optional<Fund> getFundById(int id) {
		
		Optional<Fund> optional=fundRepository.findById(id);
		return optional;
	}

}

