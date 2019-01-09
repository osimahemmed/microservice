package com.sape.it.banking.account.AccountManagement.controller;

import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sape.it.banking.account.AccountManagement.VO.AccountCreateVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountDepositVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountWithdrawalVO;
import com.sape.it.banking.account.AccountManagement.VO.FundTransferVO;
import com.sape.it.banking.account.AccountManagement.service.IAccountService;

@RestController
//@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@GetMapping(path = "/accounts/{accountNumber}")
	public ResponseEntity<AccountVO> getAccountDetails(@PathVariable Long accountNumber) {
		return new ResponseEntity<AccountVO>(accountService.getAccountDetails(accountNumber), HttpStatus.OK);
	}

	@GetMapping(path = "/accounts/balance/{accountNumber}")
	public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountNumber) {
		return new ResponseEntity<BigDecimal>(accountService.getAccountBalance(accountNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/accounts")
	public ResponseEntity<AccountVO> createAccount(@RequestBody @Valid AccountCreateVO accountCreateDTO) {
		AccountVO account = accountService.createAccount(accountCreateDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getAccountNumber()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/accounts/{accountNumber}")
	public ResponseEntity<?> closeAccount(@PathVariable Long accountNumber) {
		accountService.closeAccount(accountNumber);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/accounts/withdrawal")
	public ResponseEntity<AccountVO> accountWithdrawal(@RequestBody AccountWithdrawalVO withDrawal) {
		return new ResponseEntity<AccountVO>(accountService.accountWithdrawal(withDrawal), HttpStatus.OK);
	}

	@PutMapping(path = "/accounts/deposit")
	public ResponseEntity<AccountVO> accountDeposit(@RequestBody AccountDepositVO deposit) {
		return new ResponseEntity<AccountVO>(accountService.accountDeposit(deposit), HttpStatus.OK);
	}

	@PutMapping(path = "/accounts/fundsTransfer")
	public ResponseEntity<FundTransferVO> fundsTranfer(@RequestBody FundTransferVO fundTransferVO) {
		return new ResponseEntity<FundTransferVO>(accountService.fundTransfer(fundTransferVO), HttpStatus.OK);
	}
}
