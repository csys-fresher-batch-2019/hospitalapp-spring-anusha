package com.anusha.hospital.dao;

import com.anusha.hospital.exception.DBException;

public interface AdminDAO {

	public String login(String adminName, String passWord) throws DBException;

}
