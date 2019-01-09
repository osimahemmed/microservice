package com.sape.it.banking.account.AccountManagement.VO;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class BranchVO implements Serializable {

	private static final long serialVersionUID = 303341431792841932L;

	@NotNull
	private String branchName;
	
	@NotNull
	private String city;
	
	@NotNull
	private String ifscCode;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


}
