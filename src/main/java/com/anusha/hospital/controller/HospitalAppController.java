package com.anusha.hospital.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anusha.hospital.dao.DepartmentsDAO;
import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.dto.MessageDTO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Departments;
import com.anusha.hospital.model.Doctors;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class HospitalAppController {

	@Autowired
	DoctorsDAO dao;
	@Autowired
	DepartmentsDAO dao1;

	@GetMapping("/docRegister")
	public MessageDTO docRegister(@RequestParam("name") String name, @RequestParam("phnum") String phoneNumber,
			@RequestParam("docgender") String gender, @RequestParam("deptid") int depId,
			@RequestParam("docpwrd") String password) throws ClassNotFoundException, SQLException, DBException {

		MessageDTO msg = new MessageDTO();
		Doctors d1 = new Doctors();

		d1.setName(name);
		d1.setPhoneNumber(phoneNumber);
		d1.setDepartmentId(depId);
		d1.setPassword(password);
		d1.setGender(gender);

		int add = dao.save(d1);

		if (add == 1) {
			msg.setInfomessage("Successfully registered");
		} else {
			msg.setErrormessage("Try again");
		}
		return msg;
	}

	@GetMapping("/docLogin")
	public MessageDTO docLogin(@RequestParam("phnum") String ph, @RequestParam("password") String pass) {
		MessageDTO msg = new MessageDTO();
		boolean status = false;
		Doctors d1 = new Doctors();
		d1.setPhoneNumber(ph);
		d1.setPassword(pass);
		try {
			status = dao.login(d1);

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (status) {
			msg.setInfomessage("Login successful!!");
		} else {
			msg.setErrormessage("Invalid Login");
		}
		return msg;

	}

	@GetMapping("/listDepartments")
	public List<Departments> listDepartments() {

		List<Departments> list = null;
		try {
			list = dao1.findActiveDepartments();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@GetMapping("/listDoctors")
	public List<Doctors> listDoctors() {

		List<Doctors> list = null;
		try {
			list = dao.findAllDoctors();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
