package com.sape.it.banking.CustomerMangament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sape.it.banking.CustomerMangament.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
