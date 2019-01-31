package com.example.databaseimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.database.DatabaseUtil;
import com.example.models.Account;

public class AccountDBImpl {

	public List<Account> getAllAccounts() throws SQLException {
		Connection connection = DatabaseUtil.getDBConnection();
		Statement stmt = null;
		List<Account> accountList = new ArrayList<Account>();
		try {
			connection.setAutoCommit(false);
			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT ACCOUNTID,BALANCE,BANKIFSCCODE,CREATEDDATE,CURRENCY,NAME FROM ACCOUNT");

			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("AccountId"));
				account.setBalance(rs.getBigDecimal("Balance"));
				account.setBankIFSCCode(rs.getString("BankIFSCCode"));
				account.setCreationDate(rs.getDate("CREATEDDATE"));
				account.setCurrency(rs.getString("Currency"));
				account.setName(rs.getString("Name"));
				accountList.add(account);
			}			
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return accountList;
	}
	
	public Account createAccount(Account account) throws SQLException {
		Connection connection = DatabaseUtil.getDBConnection();
		PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);

			stmt = connection.prepareStatement("INSERT INTO ACCOUNT(Name,Balance,BankIFSCCode) VALUES(?,?,?)");
			stmt.setString(1, account.getName());
			stmt.setBigDecimal(2, account.getBalance()); 
			stmt.setString(3, account.getBankIFSCCode());
			
			int affetctedRows = stmt.executeUpdate();
			ResultSet rs=stmt.getGeneratedKeys();
			if(rs.next()){
				affetctedRows=rs.getInt(1);
			}
			account.setAccountId(affetctedRows);

			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return account;
	}

	public Account updateAccount(Account account) throws SQLException {
		Connection connection = DatabaseUtil.getDBConnection();
		PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);

			stmt = connection.prepareStatement("UPDATE ACCOUNT SET NAME=? , BALANCE=? , BANKIFSCCODE=? WHERE AccountId=?");
			stmt.setString(1, account.getName());
			stmt.setBigDecimal(2, account.getBalance()); 
			stmt.setString(3, account.getBankIFSCCode());
			stmt.setInt(4, account.getAccountId());
			int count = stmt.executeUpdate();
			
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return account;
	}

}
