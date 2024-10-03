package com.wipro.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con=null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//establish connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","riku7602");
		} catch (SQLException e) {
			e.printStackTrace();
			
        }catch (Exception e) {
        	e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
