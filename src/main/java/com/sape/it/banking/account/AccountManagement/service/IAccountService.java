package com.sape.it.banking.account.AccountManagement.service;

import java.math.BigDecimal;

import com.sape.it.banking.account.AccountManagement.VO.AccountCreateVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountDepositVO;
import com.sape.it.banking.account.AccountManagement.VO.AccountWithdrawalVO;
import com.sape.it.banking.account.AccountManagement.VO.FundTransferVO;

public interface IAccountService {
	
	public AccountVO createAccount(AccountCreateVO accountCreateDTO);

	public AccountVO getAccountDetails(Long accountNumber);

	public void closeAccount(Long accountNumber);

	public BigDecimal getAccountBalance(Long accountNumber);

	public AccountVO accountWithdrawal(AccountWithdrawalVO withdrawal);

	public AccountVO accountDeposit(AccountDepositVO deposit);
	public FundTransferVO fundTransfer(FundTransferVO fundTransFerVO);

}
