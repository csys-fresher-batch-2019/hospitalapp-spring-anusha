package com.anusha.hospital.model;

import lombok.Data;

@Data
public class Departments {

	private int id;
	private String name;
	private int active = 1;

	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

}
