package com.test.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.test.util.PConstants;
import com.test.util.PropertiesReader;

public class JdbcConnection {

	public boolean testConnection() throws IOException {
		String jdbcCConnection = PropertiesReader.getInstance().getProperty(PConstants.URL);
		String user = PropertiesReader.getInstance().getProperty(PConstants.USER);
		String password = PropertiesReader.getInstance().getProperty(PConstants.PASSWORD);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcCConnection, user, password);
			if (con != null)
				return true;

		} catch (ClassNotFoundException ex) {
			System.out.println("Could not find database driver class");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		try {
		System.out.println("connection status connected:-"+jdbcConnection.testConnection());
		}
		catch (IOException ex) {
			System.out.println("there is exception in IO"+ex);
		}
		
		
		}
	
	
}
