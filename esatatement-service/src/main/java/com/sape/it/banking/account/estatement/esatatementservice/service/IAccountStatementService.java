package com.sape.it.banking.account.estatement.esatatementservice.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sape.it.banking.account.estatement.esatatementservice.model.AccountHistory;

public interface IAccountStatementService {

	List<AccountHistory> generateAccountStatement(Pageable pageable);
}
