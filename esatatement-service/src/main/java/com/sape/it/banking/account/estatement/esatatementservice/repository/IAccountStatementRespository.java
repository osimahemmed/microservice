package com.sape.it.banking.account.estatement.esatatementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sape.it.banking.account.estatement.esatatementservice.model.AccountHistory;

public interface IAccountStatementRespository extends JpaRepository<AccountHistory, Long> {

}
