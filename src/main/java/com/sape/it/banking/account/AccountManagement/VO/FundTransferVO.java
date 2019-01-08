package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FundTransferVO implements Serializable{

	private static final long serialVersionUID = -8712348121046816215L;

	
	@NotNull
	private Long fromAccount;
	@NotNull
	private Long toAccount;
	@NotNull
	private BigDecimal fundTransferAmount;
	@NotNull
	private String debitAccountType;
	@NotNull
	private String creditAccountType;
	@NotNull
	private String description;
	
	@JsonIgnore
	private LocalDateTime localDate = LocalDateTime.now();

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public String getDebitAccountType() {
		return debitAccountType;
	}

	public void setDebitAccountType(String debitAccountType) {
		this.debitAccountType = debitAccountType;
	}

	public String getCreditAccountType() {
		return creditAccountType;
	}

	public void setCreditAccountType(String creditAccountType) {
		this.creditAccountType = creditAccountType;
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

	public BigDecimal getFundTransferAmount() {
		return fundTransferAmount;
	}

	public void setFundTransferAmount(BigDecimal fundTransferAmount) {
		this.fundTransferAmount = fundTransferAmount;
	}
	
	

}
