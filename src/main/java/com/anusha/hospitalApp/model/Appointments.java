package com.anusha.hospitalApp.model;

import lombok.Data;

@Data
public class Appointments {
	
	private int id;
	private int patientId;
	private String purpose;
	private int doctorId;
	private int active;
	private String status;
	
}