package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountVO implements Serializable {

	private static final long serialVersionUID = 7507242741791562691L;

	private Long accountNumber;
	
	@NotNull
	private String accountType;
	private BigDecimal creditAmount = BigDecimal.ZERO;
	private BigDecimal accountBalance;
	
	@JsonIgnore
	private LocalDateTime localDate = LocalDateTime.now();
	private BigDecimal debitAmount = BigDecimal.ZERO;
	private String description;



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

	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
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
