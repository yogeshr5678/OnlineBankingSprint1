package com.bootapp.rest.restapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bootapp.rest.restapp.enums.LoanStatusType;

@Entity
@Table(name="loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="installment_count")
    private Integer installmentCount;

    @Column(name="principal_loan_amount")
    private BigDecimal principalLoanAmount;

    @Column(name="monthly_loan_amount")
    private BigDecimal monthlyInstallmentAmount;

    @Column(name="interest_to_paid")
    private BigDecimal interestToBePaid;

    @Column(name="principal_to_paid")
    private BigDecimal principalToBePaid;

    @Column(name="remaining_principal")
    private BigDecimal remainingPrincipal;

    @Column(name="due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name ="loan_status")
    private LoanStatusType loanStatusType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getInstallmentCount() {
		return installmentCount;
	}

	public void setInstallmentCount(Integer installmentCount) {
		this.installmentCount = installmentCount;
	}

	public BigDecimal getPrincipalLoanAmount() {
		return principalLoanAmount;
	}

	public void setPrincipalLoanAmount(BigDecimal principalLoanAmount) {
		this.principalLoanAmount = principalLoanAmount;
	}

	public BigDecimal getMonthlyInstallmentAmount() {
		return monthlyInstallmentAmount;
	}

	public void setMonthlyInstallmentAmount(BigDecimal monthlyInstallmentAmount) {
		this.monthlyInstallmentAmount = monthlyInstallmentAmount;
	}

	public BigDecimal getInterestToBePaid() {
		return interestToBePaid;
	}

	public void setInterestToBePaid(BigDecimal interestToBePaid) {
		this.interestToBePaid = interestToBePaid;
	}

	public BigDecimal getPrincipalToBePaid() {
		return principalToBePaid;
	}

	public void setPrincipalToBePaid(BigDecimal principalToBePaid) {
		this.principalToBePaid = principalToBePaid;
	}

	public BigDecimal getRemainingPrincipal() {
		return remainingPrincipal;
	}

	public void setRemainingPrincipal(BigDecimal remainingPrincipal) {
		this.remainingPrincipal = remainingPrincipal;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LoanStatusType getLoanStatusType() {
		return loanStatusType;
	}

	public void setLoanStatusType(LoanStatusType loanStatusType) {
		this.loanStatusType = loanStatusType;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", customerId=" + customerId + ", installmentCount=" + installmentCount
				+ ", principalLoanAmount=" + principalLoanAmount + ", monthlyInstallmentAmount="
				+ monthlyInstallmentAmount + ", interestToBePaid=" + interestToBePaid + ", principalToBePaid="
				+ principalToBePaid + ", remainingPrincipal=" + remainingPrincipal + ", dueDate=" + dueDate
				+ ", loanStatusType=" + loanStatusType + "]";
	}
    
    

}
