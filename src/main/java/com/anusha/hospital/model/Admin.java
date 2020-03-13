package com.anusha.hospital.model;

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
