package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountDepositVO implements Serializable {

	private static final long serialVersionUID = -3174348016898332475L;

	@NotNull
	private Long accountNumber;
	@NotNull
	private BigDecimal depositAmount;
	@NotNull
	private String accountType;
	@NotNull
	private String description;
	
	@JsonIgnore
	private LocalDateTime localDate = LocalDateTime.now();

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


	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
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

}
