package com.bootapp.rest.restapp.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "from_account_id")
	private long fromaccountId;

	@Column(name = "to_account_id")
	private long toaccountId;

	@Column(name = "total_amount")
	private double amount;

	@Column(name = "transaction_date")
	private LocalDate date;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getFromaccountId() {
		return fromaccountId;
	}

	public void setFromaccountId(long fromaccountId) {
		this.fromaccountId = fromaccountId;
	}

	public long getToaccountId() {
		return toaccountId;
	}

	public void setToaccountId(long toaccountId) {
		this.toaccountId = toaccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromaccountId=" + fromaccountId + ", toaccountId=" + toaccountId
				+ ", amount=" + amount + ", date=" + date + "]";
	}
	
	

	
      
}