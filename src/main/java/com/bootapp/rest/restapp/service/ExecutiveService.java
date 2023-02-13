package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.ExecutiveRepository;
import com.bootapp.rest.restapp.model.Executive;

@Service
public class ExecutiveService {
@Autowired
private ExecutiveRepository executiveRepository;



public Optional <Executive> getExecutiveById(int id) {
    Optional<Executive> optional = executiveRepository.findById(id);
    return optional; 
}

public List<Executive> getAllExecutive() {
    List<Executive> list = executiveRepository.findAll();
    return list;        
}

public void insertExecutive(Executive executive) {
	executiveRepository.save(executive);
} 
}