package com.anusha.hospitalApp.dao.impl;

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
import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.exception.ErrorConstant;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.util.ConnectionUtil;

@Repository
public class DoctorsDAOImpl implements DoctorsDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(DoctorsDAOImpl.class);
	private static final String ACTION_1 = "doctor_id";
	private static final String ACTION_2 = "department_id";

	public int save(Doctors doc) throws ClassNotFoundException, SQLException, DBException {

		int rows = 0;
		String sql = "insert into doctors (doctor_id,doctor_name,department_id,doctor_password,d_phone_number,d_gender) values(doctor_id_sq.nextval,?,?,?,?,?)";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, doc.getDoctorName());
			pst.setInt(2, doc.getDepartmentId());
			pst.setString(3, doc.getDoctorPassword());
			pst.setString(4, doc.getDPhoneNumber());
			pst.setString(5, doc.getDGender());

			rows = pst.executeUpdate();
			Logger.debug("No of rows inserted " + rows);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
		return rows;
	}

	public List<Doctors> displayDoctors() throws DBException {

		List<Doctors> list = new ArrayList<>();

		String sql = "select doctor_id,doctor_name,department_id,active_doctors,doctor_presence,d_phone_number,d_gender,no_of_appointments from doctors order by doctor_id asc";

		try (Connection con = ConnectionUtil.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			while (rows.next()) {
				int doctorId = rows.getInt(ACTION_1);
				String doctorName = rows.getString("doctor_name");
				int deptId = rows.getInt(ACTION_2);
				int active = rows.getInt("active_doctors");
				int present = rows.getInt("doctor_presence");
				String dPhoneNumber = rows.getString("d_phone_number");
				String dGender = rows.getString("d_gender");
				int noOfAppointment = rows.getInt("no_of_appointments");
				Logger.debug(
						doctorId + doctorName + deptId + active + present + dPhoneNumber + dGender + noOfAppointment);
				Doctors d1 = new Doctors();
				d1.setDoctorId(doctorId);
				d1.setDoctorName(doctorName);
				d1.setDepartmentId(deptId);
				d1.setActive(active);
				d1.setDoctorPresent(present);
				d1.setDPhoneNumber(dPhoneNumber);
				d1.setDGender(dGender);
				d1.setNoOfAppointment(noOfAppointment);

				list.add(d1);

			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public void delete(int doctorId) throws ClassNotFoundException, SQLException, DBException {

		String sql = "Update doctors set active_doctors = 0 where doctor_id = ?";

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, doctorId);

			// execute query
			int rows = pst.executeUpdate();
			Logger.debug("No of rows deleted " + rows);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public List<Doctors> findByName(String doctorName) throws DBException {
		List<Doctors> list = new ArrayList<>();
		String sql = "Select doctor_id,doctor_name,department_id,doctor_presence from doctors where active_doctors = 1 and doctor_name = ? ";

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, doctorName);

			// LOGGER.debug( "Select doctor_id,department_id,active_doctors from doctors
			// where doctor_name = "+doctorName);

			// execute query
			try (ResultSet rows = pst.executeQuery()) {
				// LOGGER.debug("No of rows found: " + rows);
				while (rows.next()) {

					int doctorId = rows.getInt(ACTION_1);
					int deptId = rows.getInt(ACTION_2);
					int docPre = rows.getInt("doctor_presence");
					Logger.debug(" " + doctorId + " " + deptId);
					Doctors d1 = new Doctors();
					d1.setDoctorId(doctorId);
					d1.setDepartmentId(deptId);
					d1.setDoctorName(doctorName);
					d1.setDoctorPresent(docPre);
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

	@Override
	public List<Doctors> findByPresent() throws DBException {
		List<Doctors> list = new ArrayList<>();

		String sql = "Select doctor_id,department_id,doctor_name from doctors where doctor_presence = 1 and active_doctors=1 order by doctor_id asc";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			// execute query
			Logger.debug("No of rows found: " + rows);

			while (rows.next()) {
				int doctorId = rows.getInt(ACTION_1);
				int deptId = rows.getInt(ACTION_2);
				String docName = rows.getString("doctor_name");

				Logger.debug(doctorId + deptId + docName);

				Doctors d1 = new Doctors();
				d1.setDoctorId(doctorId);
				d1.setDepartmentId(deptId);
				d1.setDoctorName(docName);

				list.add(d1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public List<Doctors> findById(int doctorId) throws ClassNotFoundException, SQLException, DBException {

		List<Doctors> list = new ArrayList<>();

		String sql = "select doctor_id,doctor_name,department_id,active_doctors,doctor_presence,d_phone_number,d_gender,no_of_appointments from doctors where doctor_id=?";

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, doctorId);

			try (ResultSet rows = pst.executeQuery()) {

				while (rows.next()) {
					int docId = rows.getInt(ACTION_1);
					String doctorName = rows.getString("doctor_name");
					int deptId = rows.getInt(ACTION_2);
					int active = rows.getInt("active_doctors");
					int present = rows.getInt("doctor_presence");
					String dPhoneNumber = rows.getString("d_phone_number");
					String dGender = rows.getString("d_gender");
					int noOfAppointment = rows.getInt("no_of_appointments");
					Logger.debug(doctorId + doctorName + deptId + active + present + dPhoneNumber + dGender
							+ noOfAppointment);
					Doctors d1 = new Doctors();
					d1.setDoctorId(docId);
					d1.setDoctorName(doctorName);
					d1.setDepartmentId(deptId);
					d1.setActive(active);
					d1.setDoctorPresent(present);
					d1.setDPhoneNumber(dPhoneNumber);
					d1.setDGender(dGender);
					d1.setNoOfAppointment(noOfAppointment);

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

	public int getUserId(String dPhoneNumber, String doctorPassword) throws DBException {
		String sql = "select doctor_id from doctors where d_phone_number=?and doctor_password=?";
		Logger.debug(sql);
		int v = 0;
		try (Connection connection = ConnectionUtil.getconnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, dPhoneNumber);
			pst.setString(2, doctorPassword);

			try (ResultSet row = pst.executeQuery()) {
				if (row.next()) {
					v = row.getInt("doctor_Id");

				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			Logger.error(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return v;

	}

	public boolean login(Doctors doc) throws ClassNotFoundException {

		try (Connection con = ConnectionUtil.getconnection();
				CallableStatement stmt = con.prepareCall("{call doctor_login(?,?,?,?)}")) {
			stmt.setString(1, doc.getDPhoneNumber());
			stmt.setString(2, doc.getDoctorPassword());
			stmt.setInt(3, doc.getActive());
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(4);
			Logger.info("Status = " + status);
			if ((status.equals("Success")) && (doc.getActive() == 1)) {
				Logger.debug("Logged In");
				return true;
			} else {
				Logger.debug("Logged out");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.error(e.getMessage());
		}

		return false;
	}

}
