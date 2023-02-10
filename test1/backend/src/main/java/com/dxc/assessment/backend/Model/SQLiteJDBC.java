package com.dxc.assessment.backend.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBC {
	
	public Connection GetConnection() {
		Connection dbConn = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			dbConn = DriverManager.getConnection("jdbc:sqlite:backend.sqlite3");
			dbConn.setAutoCommit(false);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return dbConn;
	}
	
	public void CloseConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
