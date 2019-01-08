/**
 * 
 */
package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountCreateVO implements Serializable {
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481671735105030191L;

	@NotNull
	private String accountType;
	@NotNull	
	private BigDecimal initialDepositAmount;
	@JsonIgnore
	private LocalDateTime localDate = LocalDateTime.now();
	@NotNull
	private Long customerId;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getInitialDepositAmount() {
		return initialDepositAmount;
	}
	public void setInitialDepositAmount(BigDecimal initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
	}
	public LocalDateTime getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
}
