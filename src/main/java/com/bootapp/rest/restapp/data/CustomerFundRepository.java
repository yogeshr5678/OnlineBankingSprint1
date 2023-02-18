package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.CustomerFund;

public interface CustomerFundRepository  extends JpaRepository<CustomerFund, Integer>{

}
