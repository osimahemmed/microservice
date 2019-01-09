package com.sape.it.banking.account.AccountManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class AccountNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9218622669903687430L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}
