package com.anusha.hospitalApp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.anusha.hospitalApp.controller.IndexController;
import com.anusha.hospitalApp.dao.AdminDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.exception.ErrorConstant;
import com.anusha.hospitalApp.util.ConnectionUtil;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public String login(String adminName, String passWord) throws SQLException, ClassNotFoundException, DBException {
		String sql = "select admin_name,admin_password from admin_table where adminname='" + adminName
				+ "' and password='" + passWord + "'";
		try (Connection connection = ConnectionUtil.getconnection(); Statement stmt = connection.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				Logger.debug(sql);
				String st = null;
				if (rs.next()) {
					st = "success";
					String adminName1 = rs.getString("admin_name");
					// LOGGER.debug(adminName1);
					String Password = rs.getString("admin_password");
					// LOGGER.debug(Password);
					if (adminName.equals(adminName1) && passWord.equals(Password)) {

						Logger.debug("Login Successfull");
						return st;

					}

				} else {
					st = "failed";
					Logger.debug("Login failed");
					return st;
				}
			} catch (Exception e) {
				e.printStackTrace();
				Logger.debug(e.getMessage());
				throw new DBException(ErrorConstant.INVALID_SELECT);
			}
			return null;
		}
	}

}