package com.sape.it.banking.CustomerMangament.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sape.it.banking.CustomerMangament.model.Customer;
import com.sape.it.banking.CustomerMangament.service.ICustomerService;


@RestController
public class CustomerController {

	@Autowired
	private ICustomerService customerService;


	@PostMapping(path = "/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
		customer = customerService.createCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(customer.getCustomerId())
			.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}


}

