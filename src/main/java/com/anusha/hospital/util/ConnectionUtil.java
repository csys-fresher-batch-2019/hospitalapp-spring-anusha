package com.anusha.hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

import com.anusha.hospital.exception.DBException;

@Component
public class ConnectionUtil {

	public static Connection getConnection() throws DBException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// return
			// (DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE",
			// "anusha","anusha"));
			return (DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle"));
		} catch (ClassNotFoundException e) {
			throw new DBException(e.getMessage());
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

}
