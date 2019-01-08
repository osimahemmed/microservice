package com.sape.it.banking.account.AccountManagement.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AccountHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4814638987924348681L;
	
	@Id
	@GeneratedValue
	private Long accountHistoryId;
	
	private Long accountNumber;
	
	private String accountType;
	
	
	private BigDecimal creditAmount;
	
	private String description;
	
	private BigDecimal accountBalance;
	
	private BigDecimal debitAmount;
	
	@JsonIgnore
	private LocalDateTime date = LocalDateTime.now();

	public Long getAccountHistoryId() {
		return accountHistoryId;
	}

	public void setAccountHistoryId(Long accountHistoryId) {
		this.accountHistoryId = accountHistoryId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

}
