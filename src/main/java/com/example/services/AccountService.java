package com.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Account;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/account")
@Api(value = "/account", description = "Account Details")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {
	
//	@GET
//	@ApiOperation(value = "Account details", notes = "Get the all account details", responseClass = "com.example.models.Account")
//	public Account get() {
//		return new Account();
//	}

}
