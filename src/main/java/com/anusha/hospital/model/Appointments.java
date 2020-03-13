package com.anusha.hospital.model;

import lombok.Data;

@Data
public class Appointments {

	private int id;
	private int patientId;
	private String purpose;
	private int doctorId;
	private int active;
	private String status;

	@Override
	public String toString() {
		return "Appointments [id=" + id + ", patientId=" + patientId + ", purpose=" + purpose + ", doctorId=" + doctorId
				+ ", active=" + active + ", status=" + status + "]";
	}

}