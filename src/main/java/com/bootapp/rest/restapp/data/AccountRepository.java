package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	

}

