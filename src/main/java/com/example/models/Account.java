package com.example.models;

import java.math.BigDecimal;
import java.util.Date;

public class Account {

	private int AccountId;
	private String Name;
	private BigDecimal Balance;
	private Date CreationDate;
	private String BankIFSCCode;
	private String Currency;

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BigDecimal getBalance() {
		return Balance;
	}

	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public String getBankIFSCCode() {
		return BankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		BankIFSCCode = bankIFSCCode;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

}

class AccountCreate extends Account{

	private String Name;
	private BigDecimal Balance;
	private String BankIFSCCode;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BigDecimal getBalance() {
		return Balance;
	}

	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}

	public String getBankIFSCCode() {
		return BankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		BankIFSCCode = bankIFSCCode;
	}

}
