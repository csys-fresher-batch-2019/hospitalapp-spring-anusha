package com.anusha.hospitalApp.model;

import lombok.Data;

@Data
public class Admin {

	private String name;
	private String password;

	@Override
	public String toString() {
		return "AdminClass [adminName=" + name + ", adminPassword=" + password + "]";
	}
}
