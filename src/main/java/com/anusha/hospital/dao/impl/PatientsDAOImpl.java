package com.anusha.hospital.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.anusha.hospital.dao.PatientsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Departments;
import com.anusha.hospital.model.Doctors;
import com.anusha.hospital.model.Patients;
import com.anusha.hospital.util.ConnectionUtil;
import com.anusha.hospital.util.ErrorConstant;

@Repository
public class PatientsDAOImpl implements PatientsDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(PatientsDAOImpl.class);

	public void save(Patients p) throws DBException {

		String sql = "insert into patient (patient_id, patient_name, age, address, p_phone_number, p_gender,patient_password) values (patient_id_sq.nextval,?, ?, ?, ?, ?, ?)";

		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, p.getName());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getAddress());
			pst.setString(4, p.getPhoneNumber());
			pst.setString(5, p.getGender());
			pst.setString(6, p.getPassword());

			// execute query
			int rows = pst.executeUpdate();
			Logger.debug("No of rows inserted " + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public List<Patients> findAllPatients() throws DBException {

		List<Patients> list = new ArrayList<>();
		String sql = "select patient_id,patient_name,age, p_gender, address, p_phone_number, active_patients from patient order by patient_id asc";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			Logger.debug("Rows" + rows);

			while (rows.next()) {
				int patientId = rows.getInt("patient_id");
				String patientName = rows.getString("patient_name");
				int age = rows.getInt("age");
				String gender = rows.getString("p_gender");
				String address = rows.getString("address");
				String phoneNo = rows.getString("p_phone_number");
				int active = rows.getInt("active_patients");
				Patients d1 = new Patients();
				d1.setId(patientId);
				d1.setActive(active);
				d1.setAddress(address);
				d1.setAge(age);
				d1.setGender(gender);
				d1.setName(patientName);
				d1.setPhoneNumber(phoneNo);
				list.add(d1);
				Logger.debug(patientId + " " + patientName + " " + active + " " + age + " " + gender + " " + address
						+ " " + phoneNo + " " + active);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;
	}

	public int updateById(int patientId) throws DBException {

		String sql = "update patient set active_patients=0 where patient_id = ?";
		Logger.debug(sql + patientId);

		int rows;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, patientId);

			// execute query

			rows = pst.executeUpdate();
			Logger.debug("No of rows deleted " + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

		return rows;
	}

	public List<Patients> findById(int patientId) throws DBException {

		List<Patients> list = new ArrayList<>();
		String sql = "Select patient_id,patient_name, age, address, p_phone_number, p_gender from patient where patient_id = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, patientId);

			try (ResultSet rows = pst.executeQuery()) {
				// LOGGER.debug("No of rows found: " + rows);

				while (rows.next()) {

					String name = rows.getString("patient_name");
					int age = rows.getInt("age");
					String address = rows.getString("address");
					String phoneNumber = rows.getString("p_phone_number");
					String gender = rows.getString("p_gender");

					Logger.debug(" " + name + " " + age + " " + address + " " + phoneNumber + " " + gender);

					Patients d1 = new Patients();

					d1.setName(name);
					d1.setAddress(address);
					d1.setAge(age);
					d1.setPhoneNumber(phoneNumber);
					d1.setGender(gender);
					d1.setId(patientId);
					list.add(d1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public List<Doctors> joinDepartmentsDoctors() throws DBException {// to
																		// display
		List<Doctors> list = new ArrayList<>();

		String sql = ("select d.doctor_name,s.department_name,d.doctor_id from doctors d join departments s on d.department_id = s.department_id where d.active_doctors=1 order by d.doctor_id asc");

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			while (rows.next()) {
				String doctorName = rows.getString("doctor_name");
				int doctorId = rows.getInt("doctor_id");
				String departmentName = rows.getString("department_name");

				Departments d1 = new Departments();
				d1.setName(departmentName);
				Doctors d2 = new Doctors();
				d2.setName(doctorName);
				d2.setId(doctorId);
				d2.setDepartment(d1);
				list.add(d2);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getLocalizedMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public int findId(String pPhoneNumber, String patientPassword) throws DBException {
		String sql = "select patient_id from patient where p_phone_number=?and patient_password=?";
		System.out.println(sql);
		int v = 0;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, pPhoneNumber);
			pst.setString(2, patientPassword);

			try (ResultSet row = pst.executeQuery()) {
				if (row.next()) {
					v = row.getInt("patient_Id");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getLocalizedMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return v;

	}

	public boolean login(Patients user) throws DBException {

		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement stmt = con.prepareCall("{call patient_login(?,?,?,?)}")) {
			stmt.setString(1, user.getPhoneNumber());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getActive());
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(4);
			Logger.info("Status = " + status);
			if ((status.equals("Success")) && (user.getActive() == 1)) {
				Logger.debug("Logged In");
				return true;
			} else {
				Logger.debug("Logged out");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getLocalizedMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
	}

}
