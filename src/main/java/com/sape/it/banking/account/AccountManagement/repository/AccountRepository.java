package com.sape.it.banking.account.AccountManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sape.it.banking.account.AccountManagement.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
