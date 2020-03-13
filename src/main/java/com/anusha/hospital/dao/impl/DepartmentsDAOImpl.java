package com.anusha.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.anusha.hospital.dao.DepartmentsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Departments;
import com.anusha.hospital.util.ConnectionUtil;
import com.anusha.hospital.util.ErrorConstant;

@Repository
public class DepartmentsDAOImpl implements DepartmentsDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(DepartmentsDAOImpl.class);

	public void save(Departments dept) throws DBException {

		String sql = "insert into departments (department_id,department_name)values (department_id_sq.nextval,?)";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, dept.getName());

			int rows = pst.executeUpdate();
			Logger.debug("No of rows inserted " + rows);

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public List<Departments> findAllDepartments() throws DBException {

		List<Departments> list = new ArrayList<>();
		String sql = "select department_id,department_name, active_departments from departments order by department_id asc";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			Logger.debug("Rows" + rows);

			while (rows.next()) {
				String deptName = rows.getString("department_name");
				int deptId = rows.getInt("department_id");
				int active = rows.getInt("active_departments");
				Logger.debug(deptId + "-" + deptName);

				Departments d1 = new Departments();
				d1.setId(deptId);
				d1.setName(deptName);
				d1.setActive(active);

				list.add(d1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;

	}

	public int updateDepartmentStatus(int active, int departmentID) throws DBException {

		String sql = "Update departments set active_departments = ? where department_id = ?";
		Logger.debug(sql);
		int rows;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			// prepare query
			pst.setInt(1, active);
			pst.setInt(2, departmentID);

			// execute query
			rows = pst.executeUpdate();
			Logger.debug("No of rows updated " + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
		return rows;

	}

	public List<Departments> findActiveDepartments() throws DBException {

		List<Departments> list = new ArrayList<>();
		String sql = "select department_id,department_name from departments where active_departments = 1 order by department_id asc";
		Logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			Logger.debug("Rows" + rows);

			while (rows.next()) {
				String deptName = rows.getString("department_name");
				int deptId = rows.getInt("department_id");

				Logger.debug(deptId + "-" + deptName);

				Departments d1 = new Departments();
				d1.setId(deptId);
				d1.setName(deptName);

				list.add(d1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;

	}

}
