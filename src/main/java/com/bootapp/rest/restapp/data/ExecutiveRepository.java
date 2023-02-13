package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Executive;


public interface  ExecutiveRepository extends JpaRepository<Executive,Integer> {

}