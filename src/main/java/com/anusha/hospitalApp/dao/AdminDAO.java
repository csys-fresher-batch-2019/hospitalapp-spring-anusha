package com.anusha.hospitalApp.dao;

import com.anusha.hospitalApp.exception.DBException;

public interface AdminDAO {

	public String login(String adminName, String passWord) throws DBException;

}
