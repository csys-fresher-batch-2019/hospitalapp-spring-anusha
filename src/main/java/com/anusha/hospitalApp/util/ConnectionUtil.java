package com.anusha.hospitalApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {
	
	
//	 private ConnectionUtil() {
//		    throw new IllegalStateException("Utility class");
//		  }
	 
	public static Connection getconnection() throws SQLException, ClassNotFoundException
	{
		 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//return (DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "anusha","anusha"));
	return (DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle"));
	}

}
