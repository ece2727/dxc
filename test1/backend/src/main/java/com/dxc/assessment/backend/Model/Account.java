package com.dxc.assessment.backend.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
	private int accountId;
	private String username;
	private String password;
	private String name;
	private String role;
	
	public Account() {
		super();
	}
	
	public Account(String username) {
		super();
		this.username = username;
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account(int accountId, String username, String name, String role) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.name = name;
		this.role = role;
	}
	
	public Account(int accountId, String username, String password, String name, String role) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + accountId + ", username=" + username + ", password=" + password + ", name=" + name + ", role="
				+ role + ", dbConn=" + dbConn + "]";
	}

	// Database Access
	SQLiteJDBC dbConn = new SQLiteJDBC();
	
	public boolean Login() {
		boolean result = false;
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = dbConn.GetConnection();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE username = ? AND password = ?");
			stmt.setString(1, this.getUsername());
			stmt.setString(2, this.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())
				result = true;
			
			dbConn.CloseConnection(conn);
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return result;
	}
	
	public Account RetrieveAccount() {
		Account account = new Account();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = dbConn.GetConnection();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE username = ?");
			stmt.setString(1, this.getUsername());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())
				account = new Account(rs.getInt("accountId"), rs.getString("username"), rs.getString("name"), rs.getString("role"));
			else
				account = null;
			
			dbConn.CloseConnection(conn);
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return account;
	}
}
