package com.bootapp.rest.restapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootapp.rest.restapp.enums.AcctStatus;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acctID;
	private double balance;
	
	@Enumerated(EnumType.STRING)
	private AcctStatus acctStatus;
	private LocalDate startDate;

	@ManyToOne
	private Customer customer;

	public Account() {

	}

	public Account(int acctID, double balance, AcctStatus acctStatus, LocalDate startDate) {
		super();
		this.acctID = acctID;
		this.balance = balance;
		this.acctStatus = acctStatus;
		this.startDate = startDate;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public AcctStatus getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(AcctStatus acctStatus) {
		this.acctStatus = acctStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}