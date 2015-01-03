package com.jenaneggs.random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInserter {
	private Connection dbconn;
	private PreparedStatement ps;
	public void insertMe(String pswd) {
		dbconn=dbConnection();
		try {
			ps=dbconn.prepareStatement("INSERT INTO eggs (code,status) VALUES (?,0);");
			ps.setString(1, pswd);
			ps.executeUpdate();
			dbconn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 

	private Connection dbConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3307/";
		String dbName = "codedb";
		String userName = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
