package com.anusha.hospitalApp.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.anusha.hospitalApp.util.ConnectionUtil;
import com.anusha.hospitalApp.util.Logger;

public class Doctors {

	private static final Logger LOGGER = Logger.getInstance();
	private int doctorId;
	private String doctorName;
	private int departmentId;
	private String doctorPassword;
	private int activeDoctor=1;
	private int doctorPresent=0;
	private String dGender;
	private String dPhoneNumber;
	private int noOfAppointment;	
	private Departments department;
	
	public String getdPhoneNumber() {
		return dPhoneNumber;
	}
	public void setdPhoneNumber(String dPhoneNumber) {
		this.dPhoneNumber = dPhoneNumber;
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
	public String getdGender() {
		return dGender;
	}
	public void setdGender(String dGender) {
		this.dGender = dGender;
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
		return activeDoctor;
	}
	public void setActive(int active) {
		this.activeDoctor = active;
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
public boolean login(Doctors user) {
		
		try(Connection con = ConnectionUtil.getconnection();
				CallableStatement stmt=con.prepareCall("{call doctor_login(?,?,?,?)}")) {
		stmt.setString(1,user.getdPhoneNumber());
		stmt.setString(2, user.getDoctorPassword());
		stmt.setInt(3, user.getActive());
		stmt.registerOutParameter(4, Types.VARCHAR);
		stmt.executeUpdate();
		String status=stmt.getString(4);
		LOGGER.info("Status = "+status);
		if((status.equals("Success")) && (user.activeDoctor==1)) {
		LOGGER.debug("Logged In");
		return true;
		}
		else {
		LOGGER.debug("Logged out");
		return false;
		}
		} catch (Exception e) {
		LOGGER.debug(e);
		}

		return false;
		}
}
