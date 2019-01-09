package com.sape.it.banking.CustomerMangament.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sape.it.banking.CustomerMangament.model.Customer;
import com.sape.it.banking.CustomerMangament.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customerVO) {
		return customerRepository.save(customerVO);
	}

	@Override
	public Customer updateCustomer(Customer customerVO) {
		return customerRepository.save(customerVO);
	}
	

}
