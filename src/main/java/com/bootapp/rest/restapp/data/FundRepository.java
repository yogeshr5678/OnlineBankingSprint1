package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Fund;

public interface FundRepository extends JpaRepository<Fund,Integer> {

}