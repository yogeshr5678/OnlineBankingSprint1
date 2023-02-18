package com.bootapp.rest.restapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.bootapp.rest.restapp.enums.FundEnum;

@Entity
@Table(name = "funds")
public class Fund {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name = "min_sip_amount")
	private double sip_amount;
	
	@Column(name = "total_years")
	private double years;
	
	@Column(name = "Interest")
	private double interest;
	
	@Column(name = "total_balance")
	private double balance;
	
	@Enumerated(EnumType.STRING)
	private FundEnum fundenum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public double getSip_amount() {
		return sip_amount;
	}

	public void setSip_amount(double sip_amount) {
		this.sip_amount = sip_amount;
	}

	public double getYears() {
		return years;
	}

	public void setYears(double years) {
		this.years = years;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public FundEnum getFundenum() {
		return fundenum;
	}

	public void setFundenum(FundEnum fundenum) {
		this.fundenum = fundenum;
	}

	@Override
	public String toString() {
		return "Fund [id=" + id + ", company_name=" + company_name + ", sip_amount=" + sip_amount + ", years=" + years
				+ ", interest=" + interest + ", balance=" + balance + ", fundenum=" + fundenum + "]";
	}
	
	

}