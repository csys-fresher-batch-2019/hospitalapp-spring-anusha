package com.anusha.hospitalApp.model;

import lombok.Data;

@Data
public class Doctors {

	private int id;
	private String name;
	private String gender;
	private String phoneNumber;
	private int departmentId;
	private int present = 0;
	private int noOfAppointment;
	private int active = 1;
	private String password;
	private Departments department;
	@Override
	public String toString() {
		return "Doctors [doctorId=" + id + ", doctorName=" + name + ", doctorGender=" + gender
				+ ", doctorPhoneNumber=" + phoneNumber + ", departmentId=" + departmentId + ", doctorPresent="
				+ present + ", noOfAppointment=" + noOfAppointment + ", activeDoctor=" + active
				+ ", doctorPassword=" + password + ", department=" + department + "]";
	}

	
}
