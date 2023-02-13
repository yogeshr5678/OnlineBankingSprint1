package com.bootapp.rest.restapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bootapp.rest.restapp.enums.Gender;

@Entity
@Table(name="customers")
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="cust_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="cust_address")
	private String address;
	
	@Column(name = "cust_phone")
	private long number;
	
	@Column(name = "cust_email")
	private String emailId;
	
	
	@OneToOne
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

//	public LocalDate getLoandate() {
//		return loandate;
//	}
//
//	public void setLoandate(LocalDate loandate) {
//		this.loandate = loandate;
//	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", number="
				+ number + ", emailId=" + emailId +  "]";
	}
}