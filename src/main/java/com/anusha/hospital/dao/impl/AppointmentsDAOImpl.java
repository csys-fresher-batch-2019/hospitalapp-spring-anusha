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
import com.anusha.hospital.dao.AppointmentsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Appointments;
import com.anusha.hospital.util.ConnectionUtil;
import com.anusha.hospital.util.ErrorConstant;

@Repository
public class AppointmentsDAOImpl implements AppointmentsDAO {

	private static final String ACTION_1 = "appointment_id";
	private static final String ACTION_2 = "purpose";
	private static final String ACTION_3 = "active_appointments";
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(AppointmentsDAOImpl.class);

	public void save(Appointments app) throws DBException {

		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement stmt = con.prepareCall("{call appointment_fixing(?,?,?,?)}")) {

			stmt.setInt(1, app.getPatientId());
			stmt.setString(2, app.getPurpose());
			stmt.setInt(3, app.getDoctorId());
			stmt.setString(4, app.getStatus());
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(4);
			Logger.debug(status);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}

	}

	public List<Appointments> findAllAppointments() throws DBException {

		List<Appointments> list = new ArrayList<>();

		String sql = "select appointment_id, patient_id, purpose, doctor_id, active_appointments,appointment_status from appointment order by appointment_id asc";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			Logger.debug("Rows" + rows);

			while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				int patientId = rows.getInt("patient_id");
				String purpose = rows.getString(ACTION_2);
				int docId = rows.getInt("doctor_id");
				int activeApp = rows.getInt(ACTION_3);
				String appointmentStatus = rows.getString("appointment_status");
				Logger.debug(
						appId + "" + patientId + "" + purpose + "" + docId + "" + activeApp + "" + appointmentStatus);
				Appointments d1 = new Appointments();
				d1.setActive(activeApp);
				d1.setPatientId(patientId);
				d1.setDoctorId(docId);
				d1.setId(appId);
				d1.setPurpose(purpose);
				d1.setStatus(appointmentStatus);
				list.add(d1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public int updateAppointmentStatus(int appointmentId) throws DBException {

		String sql = "Update appointment set active_appointments = 0 where appointment_id = ?";
		Logger.debug(sql);

		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, appointmentId);

			rows = pst.executeUpdate();
			Logger.debug("No of rows deleted " + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

		return rows;
	}

	public List<Appointments> findAppointmentByPatientId(int patientId) throws DBException {

		List<Appointments> list = new ArrayList<>();
		String sql = "Select appointment_id,patient_id, purpose, doctor_id, active_appointments, appointment_status from appointment where patient_id = ? order by appointment_id asc";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, patientId);

			Logger.debug(sql + patientId);
			try (ResultSet rows = pst.executeQuery();) {
				Logger.debug("No of rows found: " + rows);

				while (rows.next()) {
					int appId = rows.getInt(ACTION_1);
					String purpose = rows.getString(ACTION_2);
					int doctorId = rows.getInt("doctor_id");
					int active = rows.getInt(ACTION_3);
					String appointmentStatus = rows.getString("appointment_status");
					int patId = rows.getInt("patient_id");

					Appointments d1 = new Appointments();

					d1.setId(appId);
					d1.setDoctorId(doctorId);
					d1.setPatientId(patId);
					d1.setPurpose(purpose);
					d1.setStatus(appointmentStatus);
					d1.setActive(active);

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

	public List<Appointments> findAppointmentByDoctorId(int doctorId) throws DBException {

		List<Appointments> list = new ArrayList<>();
		String sql = "Select appointment_id, purpose, doctor_id, patient_id, active_appointments ,appointment_status from appointment where doctor_id = ? order by appointment_id asc";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, doctorId);
			Logger.debug(sql + doctorId);

			try (ResultSet rows = pst.executeQuery();) {
				Logger.debug("No of rows found: " + rows);

				while (rows.next()) {
					int appId = rows.getInt(ACTION_1);
					String purpose = rows.getString(ACTION_2);
					int patientId = rows.getInt("patient_id");
					int active = rows.getInt(ACTION_3);
					String appointmentStatus = rows.getString("appointment_status");
					Appointments d2 = new Appointments();

					d2.setId(appId);
					d2.setPurpose(purpose);
					d2.setDoctorId(doctorId);
					d2.setPatientId(patientId);
					d2.setActive(active);
					d2.setStatus(appointmentStatus);

					list.add(d2);

					Logger.debug(appId + " " + purpose + " " + patientId + " " + active);

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}
}
