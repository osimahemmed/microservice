package com.sape.it.banking.account.estatement.esatatementservice.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sape.it.banking.account.estatement.esatatementservice.model.AccountHistory;
import com.sape.it.banking.account.estatement.esatatementservice.repository.IAccountStatementRespository;

@Service
public class AccountStatementServiceImpl implements IAccountStatementService {
	
	@Autowired
	private IAccountStatementRespository repository;

	@Override
	public List<AccountHistory> generateAccountStatement(Pageable pageable) {
		
		return (List<AccountHistory>) repository.findAll(pageable)
				.getContent().stream().collect(Collectors.toList());
		
	}

}
