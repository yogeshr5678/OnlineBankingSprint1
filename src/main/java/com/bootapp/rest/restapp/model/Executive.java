package com.bootapp.rest.restapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "executives")
public class Executive {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "executive_name")
	private String name;

	@Column(name = "executive_email_id")
	private String emailId;

	@Column(name = "executive_phone_no")
	private String phoneNo;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Executive [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
	}

}