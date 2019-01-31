package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

	public static Connection getDBConnection() {
		final String DB_DRIVER = "org.h2.Driver";
		final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
		final String DB_USER = "";
		final String DB_PASSWORD = "";

		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public void createDBStatement() throws SQLException {

		Connection connection = getDBConnection();
		Statement stmt = null;
		try {
			connection.setAutoCommit(false);
			stmt = connection.createStatement();

			 stmt.execute("CREATE TABLE ACCOUNT(ACCOUNTID INT AUTO_INCREMENT PRIMARY KEY , NAME VARCHAR(255) , BALANCE DECIMAL ,CREATEDDATE DATETIME DEFAULT SYSDATE,UPDATEDDATE DATETIME , BANKIFSCCODE VARCHAR(255) , CURRENCY VARCHAR(255) DEFAULT 'GBP')");
//			 stmt.execute("INSERT INTO ACCOUNT(Name,Balance,CreationDate,BankIFSCCode) VALUES('A', 100,SYSDATE,'SBESC1')");
//			 stmt.execute("INSERT INTO ACCOUNT(Name,Balance,CreationDate,BankIFSCCode) VALUES('B', 200,SYSDATE,'SBESC2')");
//			 stmt.execute("INSERT INTO ACCOUNT(Name,Balance,CreationDate,BankIFSCCode) VALUES('C',300,SYSDATE,'SBESC3')");
//			 stmt.execute("INSERT INTO ACCOUNT(Name,Balance,CreationDate,BankIFSCCode) VALUES('D',300,SYSDATE,'SBESC3')");

			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
