/**
 * 
 */
package com.sape.it.banking.account.AccountManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InSufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = 7279655562973346243L;

	public InSufficientFundsException(String message) {
		super(message);
	}

}
