package com.anusha.hospitalApp.model;

public class Doctors {

	private int doctorId;
	private String doctorName;
	private int departmentId;
	private String doctorPassword;
	private int active=1;
	private int doctorPresent=0;
	private String gender;
	private String phoneNumber;
	private int noOfAppointment;	
	private Departments department;
	
	public String getDPhoneNumber() {
		return phoneNumber;
	}
	public void setDPhoneNumber(String dPhoneNumber) {
		this.phoneNumber = dPhoneNumber;
	}
	public int getDoctorPresent() {
		return doctorPresent;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	public void setDoctorPresent(int doctorPresent) {
		this.doctorPresent = doctorPresent;
	}
	public String getDGender() {
		return gender;
	}
	public void setDGender(String dGender) {
		this.gender = dGender;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public int getNoOfAppointment() {
		return noOfAppointment;
	}
	public void setNoOfAppointment(int noOfAppointment) {
		this.noOfAppointment = noOfAppointment;
	}

}
