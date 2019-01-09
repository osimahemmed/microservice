package com.sape.it.banking.account.estatement.esatatementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sape.it.banking.account.estatement.esatatementservice.model.AccountHistory;
import com.sape.it.banking.account.estatement.esatatementservice.service.IAccountStatementService;

@RestController
public class AccountStatementController {
	
	@Autowired
	private IAccountStatementService service;
	
	@GetMapping("/statement")
	public ResponseEntity<List<AccountHistory>> getStatement(Pageable pageable) {
		return new ResponseEntity<List<AccountHistory>>(service.generateAccountStatement(pageable), HttpStatus.OK);
	}
}
