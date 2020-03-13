package com.anusha.hospital.model;

import lombok.Data;

@Data
public class Patients {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String phoneNumber;
	private String password;
	private int active = 1;

	@Override
	public String toString() {
		return "Patients [patientId=" + id + ", patientName=" + name + ", age=" + age + ", pGender=" + gender
				+ ", address=" + address + ", pPhoneNumber=" + phoneNumber + ", patientPassword=" + password
				+ ", activePatient=" + active + "]";
	}

}
