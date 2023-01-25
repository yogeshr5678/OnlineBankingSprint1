package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
