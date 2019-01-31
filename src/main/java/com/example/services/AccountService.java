package com.example.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.inputmodels.AccountCreate;
import com.example.inputmodels.AccountUpdate;
import com.example.models.Account;
import com.example.servicesimpl.AccountServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/account")
@Api(value = "/getAccountDetails", description = "Account Details")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {
	
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Add Account", notes = "Expects an object like { Name : 'A' ,Balance : '200.20' , BankIFSCCode : 'ADCB' }")	
	public Account createAccount(@ApiParam(value = "Account object", required = true) AccountCreate account) {
		try {
			return accountServiceImpl.createAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@PUT
	@Path("/updateAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Add Account", notes = "Expects an object like { Name : 'A' ,Balance : '200.20' , BankIFSCCode : 'ADCB' }")	
	public Account updateAccount(@ApiParam(value = "Account object", required = true) AccountUpdate account) {
		try {
			return accountServiceImpl.updateAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	@GET
	@ApiOperation(value = "Account details", notes = "Get the all account details", responseClass = "com.example.models.Account")
	public List<Account> getAllAccounts() {
		try{
			return accountServiceImpl.getAllAccounts();			
		}catch(Exception e){
			return null;
		}
	}

}
