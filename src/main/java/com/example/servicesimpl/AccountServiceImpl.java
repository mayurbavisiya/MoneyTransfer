package com.example.servicesimpl;

import java.sql.SQLException;
import java.util.List;

import com.example.databaseimpl.AccountDBImpl;
import com.example.inputmodels.AccountCreate;
import com.example.inputmodels.AccountUpdate;
import com.example.models.Account;

public class AccountServiceImpl {

	AccountDBImpl accountDBImpl = new AccountDBImpl();

	public List<Account> getAllAccounts() throws SQLException {
		return accountDBImpl.getAllAccounts();
	}

	public Account createAccount(AccountCreate accountInput) throws SQLException {
		Account account = new Account();
		account.setName(accountInput.getName());
		account.setBankIFSCCode(accountInput.getBankIFSCCode());
		account.setBalance(accountInput.getBalance());
		return accountDBImpl.createAccount(account);
	}

	public Account updateAccount(AccountUpdate accountUpdate) throws SQLException {
		Account account = new Account();
		account.setAccountId(accountUpdate.getAccountId());
		account.setName(accountUpdate.getName());
		account.setBankIFSCCode(accountUpdate.getBankIFSCCode());
		account.setBalance(accountUpdate.getBalance());
		return accountDBImpl.updateAccount(account);		
	}
}
