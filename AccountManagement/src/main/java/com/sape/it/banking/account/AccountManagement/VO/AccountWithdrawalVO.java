package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountWithdrawalVO implements Serializable {

	private static final long serialVersionUID = 3824647487148112770L;

	
	@NotNull
	private String accountType;
	@NotNull
	private BigDecimal withdrawalAmount;
	
	@NotNull
	private Long accountNumber;

	@JsonIgnore
	private LocalDateTime localDate = LocalDateTime.now();
	@NotNull
	private String description;
	
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

	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
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
