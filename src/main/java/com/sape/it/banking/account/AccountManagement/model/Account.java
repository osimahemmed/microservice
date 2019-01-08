package com.sape.it.banking.account.AccountManagement.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = -8319045543797354213L;

	@Id
	@GeneratedValue
	private Long accountNumber;
	@JsonIgnore
	private LocalDateTime date = LocalDateTime.now();
	private String accountType;
	private BigDecimal accountBalance;
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
}
