package com.example.inputmodels;

import java.math.BigDecimal;

public class AccountCreate {

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
