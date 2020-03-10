 package com.anusha.hospitalApp.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.dto.MessageDTO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Doctors;

@RestController
@RequestMapping("api")
public class HospitalAppController {

	@Autowired
	DoctorsDAO dao ;
	
	@GetMapping("/docRegister")
	public MessageDTO docRegister(@RequestParam("name") String name, @RequestParam("phnum") String phoneNumber,
			@RequestParam("docgender") String gender, @RequestParam("deptid") int depId,
			@RequestParam("docpwrd") String password) throws ClassNotFoundException, SQLException, DBException {

		MessageDTO msg = new MessageDTO();
		Doctors d1 = new Doctors();

		d1.setDoctorName(name);
		d1.setDPhoneNumber(phoneNumber);
		d1.setDepartmentId(depId);
		d1.setDoctorPassword(password);
		d1.setDGender(gender);
		
		int add = dao.save(d1);
		
		if (add==1) {
			msg.setInfomessage("Successfully registered");
		}
		else
		{
			msg.setErrormessage("Try again");
		}
		return msg;
}
}
