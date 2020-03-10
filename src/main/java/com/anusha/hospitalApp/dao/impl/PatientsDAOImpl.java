package com.anusha.hospitalApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.anusha.hospitalApp.controller.IndexController;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.exception.ErrorConstant;
import com.anusha.hospitalApp.model.Departments;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.model.Patients;
import com.anusha.hospitalApp.util.ConnectionUtil;

@Repository
public class PatientsDAOImpl implements PatientsDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);
	
	public void save(Patients p) throws ClassNotFoundException, SQLException, DBException {

		String sql = "insert into patient (patient_id, patient_name, age, address, p_phone_number, p_gender,patient_password) values (patient_id_sq.nextval,?, ?, ?, ?, ?, ?)";

		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, p.getPatientName());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getAddress());
			pst.setString(4, p.getpPhoneNumber());
			pst.setString(5, p.getpGender());
			pst.setString(6,p.getPatientPassword());

			// execute query
			int rows = pst.executeUpdate();
			Logger.debug("No of rows inserted " + rows);
		} 
		catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public List<Patients> findAll() throws DBException {

		List<Patients> list = new ArrayList<>();
		String sql = "select patient_id,patient_name,age, p_gender, address, p_phone_number, active_patients from patient order by patient_id asc";
		Logger.debug(sql);
	
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			Logger.debug("Rows"+rows);
			
			while (rows.next()) {
				int patientId = rows.getInt("patient_id");
				String patientName = rows.getString("patient_name");
				int age = rows.getInt("age");
				String gender = rows.getString("p_gender");
				String address = rows.getString("address");
				String phoneNo = rows.getString("p_phone_number");
				int active = rows.getInt("active_patients");
				Patients d1 = new Patients();
				d1.setPatientId(patientId);
				d1.setActivePatient(active);
				d1.setAddress(address);
				d1.setAge(age);
				d1.setpGender(gender);
				d1.setPatientName(patientName);
				d1.setpPhoneNumber(phoneNo);
				list.add(d1);
				Logger.debug(patientId+" "+patientName+" "+active+" "+age+" "+gender+" "+address+" "+phoneNo+" "+active);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;
	}

	public void update(int patientId) throws ClassNotFoundException, SQLException, DBException {

		String sql = "update patient set active_patients=0 where patient_id = ?";
		Logger.debug(sql+patientId);

		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, patientId);

			// execute query
			
			int rows = pst.executeUpdate();
			Logger.debug("No of rows deleted " + rows);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

	}

	public List<Patients> findById(int patientId) throws SQLException, ClassNotFoundException, DBException {

		List<Patients> list = new ArrayList<>();
		String sql = "Select patient_id,patient_name, age, address, p_phone_number, p_gender from patient where patient_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); 
				PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, patientId);

			try(ResultSet rows = pst.executeQuery()){
			//LOGGER.debug("No of rows found: " + rows);

			while (rows.next()) {		
				
				String name = rows.getString("patient_name");
				int age = rows.getInt("age");
				String address = rows.getString("address");
				String phoneNumber = rows.getString("p_phone_number");
				String gender = rows.getString("p_gender");
				
				Logger.debug(" "+name+" "+age+" "+address+" "+phoneNumber+" "+gender);
				
				Patients d1 = new Patients();
				
				d1.setPatientName(name);
				d1.setAddress(address);
				d1.setAge(age);
				d1.setpPhoneNumber(phoneNumber);
				d1.setpGender(gender);
				d1.setPatientId(patientId);
				list.add(d1);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}
	
	public List<Doctors> joinDepartmentsDoctors() throws SQLException, ClassNotFoundException, DBException  {//to display doctor name nd id during doctor id entry
		
		List<Doctors> list = new ArrayList<>();
		
		String sql = ("select d.doctor_name,s.department_name,d.doctor_id from doctors d join departments s on d.department_id = s.department_id where d.active_doctors=1 order by d.doctor_id asc");

		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			
			while (rows.next())
			{
				String doctorName = rows.getString("doctor_name") ;
				int doctorId = rows.getInt("doctor_id");
				String departmentName = rows.getString("department_name") ;
				
				Departments d1= new Departments();
				d1.setDepartmentName(departmentName);
				Doctors d2 = new Doctors();
				d2.setDoctorName(doctorName);
				d2.setDoctorId(doctorId);
				d2.setDepartment(d1);
				list.add(d2);

			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getLocalizedMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public int findByPhNoPasswrd(String pPhoneNumber, String patientPassword) throws DBException {
		String sql="select patient_id from patient where p_phone_number=?and patient_password=?";
		System.out.println(sql);
		int v= 0;
		try(Connection connection=ConnectionUtil.getconnection();
		     PreparedStatement pst = connection.prepareStatement(sql);){
		       pst.setString(1,pPhoneNumber);
		       pst.setString(2,patientPassword);
		       
		       try(ResultSet row =pst. executeQuery())
		{
		                if(row.next()) {
		               	v= row.getInt("patient_Id");
		               	
		                }
		}  }catch(SQLException | ClassNotFoundException e)
		{

			e.printStackTrace();
			Logger.error(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		        }
		                return v;



		}


}
