package com.sape.it.banking.account.AccountManagement.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sape.it.banking.account.AccountManagement.VO.AccountCreateVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountDepositVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountWithdrawalVO;
import com.sape.it.banking.account.AccountManagement.VO.FundTransferVO;
import com.sape.it.banking.account.AccountManagement.exception.AccountNotFoundException;
import com.sape.it.banking.account.AccountManagement.exception.InSufficientFundsException;
import com.sape.it.banking.account.AccountManagement.model.Account;
import com.sape.it.banking.account.AccountManagement.model.AccountHistory;
import com.sape.it.banking.account.AccountManagement.repository.AccountHistoryRepository;
import com.sape.it.banking.account.AccountManagement.repository.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountHistoryRepository accountHistoryRepository;

	@Override
	public AccountVO createAccount(AccountCreateVO accountCreateVO) {

		Account account = new Account();
		account.setAccountBalance(accountCreateVO.getInitialDepositAmount());
		account.setAccountType(accountCreateVO.getAccountType());
		account = accountRepository.save(account);

		ModelMapper mapper = new ModelMapper();
		return mapper.map(account, AccountVO.class);
	}

	@Override
	public AccountVO getAccountDetails(Long accountNumber) {
		Optional<Account> optAccount = accountRepository.findById(accountNumber);
		Account account = optAccount.orElseThrow(() -> new AccountNotFoundException(" Account not found : " + accountNumber));
		ModelMapper mapper = new ModelMapper();
		return mapper.map(account, AccountVO.class);
	}

	@Override
	public void closeAccount(Long accountNumber) {
			accountRepository.deleteById(accountNumber);
		}

	@Override
	public BigDecimal getAccountBalance(Long accountNumber) {
		return getAccountDetails(accountNumber).getAccountBalance();
		}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AccountVO accountWithdrawal(AccountWithdrawalVO withdrawalVO) {

		AccountVO accountVO = getAccountDetails(withdrawalVO.getAccountNumber());

		BigDecimal balance = accountVO.getAccountBalance();
		BigDecimal remainingBalance = balance.subtract(withdrawalVO.getWithdrawalAmount());

		if (remainingBalance.compareTo(BigDecimal.ZERO) <= 0) {
			throw new InSufficientFundsException(
					"Insufficient balance for account number : " + accountVO.getAccountNumber());
		}

		accountVO.setAccountBalance(remainingBalance);
		accountVO.setDebitAmount(withdrawalVO.getWithdrawalAmount());
		accountVO.setDescription(withdrawalVO.getDescription());
		accountVO.setLocalDate(LocalDateTime.now());
		updateAccount(accountVO);
		return updateAccountHistory(accountVO);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AccountVO accountDeposit(AccountDepositVO depositVO) {
		AccountVO accountVO = getAccountDetails(depositVO.getAccountNumber());

		BigDecimal balance = accountVO.getAccountBalance();

		accountVO.setAccountBalance(balance.add(depositVO.getDepositAmount()));
		accountVO.setCreditAmount(depositVO.getDepositAmount());
		accountVO.setDescription(depositVO.getDescription());
		accountVO.setLocalDate(LocalDateTime.now());

		updateAccount(accountVO);
		return updateAccountHistory(accountVO);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	private AccountVO updateAccount(AccountVO accountVO) {
		ModelMapper mapper = new ModelMapper();
		Account account = accountRepository.save(mapper.map(accountVO, Account.class));
		return mapper.map(account, AccountVO.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private AccountVO updateAccountHistory(AccountVO accountVO) {
		ModelMapper mapper = new ModelMapper();
		AccountHistory accountHistory = accountHistoryRepository.save(mapper.map(accountVO, AccountHistory.class));

		return mapper.map(accountHistory, AccountVO.class);
	}
	
	@SuppressWarnings("unused")
	@Transactional(propagation = Propagation.REQUIRED)
	public FundTransferVO fundTransfer(FundTransferVO fundTransferVO) {
		AccountWithdrawalVO debitVO = new AccountWithdrawalVO();
		debitVO.setAccountNumber(fundTransferVO.getFromAccount());
		debitVO.setAccountType(fundTransferVO.getDebitAccountType());
		debitVO.setWithdrawalAmount(fundTransferVO.getFundTransferAmount());
		debitVO.setDescription(fundTransferVO.getDescription());
		debitVO.setLocalDate(fundTransferVO.getLocalDate());
		AccountDepositVO creditVO = new AccountDepositVO();
		creditVO.setAccountNumber(fundTransferVO.getToAccount());
		creditVO.setDepositAmount(fundTransferVO.getFundTransferAmount());
		creditVO.setAccountType(fundTransferVO.getCreditAccountType());
		creditVO.setDescription(fundTransferVO.getDescription());
		creditVO.setLocalDate(fundTransferVO.getLocalDate());
		ModelMapper mapper = new ModelMapper();
		AccountVO fromAccount = accountWithdrawal(debitVO);
		AccountVO toAccount = accountDeposit(creditVO);
		return mapper.map(fundTransferVO, FundTransferVO.class);

	}
	
	

}
