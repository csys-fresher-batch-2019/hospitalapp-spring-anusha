package com.anusha.hospital.validator;

import com.anusha.hospital.exception.ValidatorException;
import com.anusha.hospital.model.Departments;
import com.anusha.hospital.model.Doctors;
import com.anusha.hospital.model.Patients;

public class Validator {

	public static void validatePatientRegister(Patients p) throws ValidatorException {

		if (p.getName() == null || "".equals(p.getName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (p.getAge() == 0) {
			throw new ValidatorException("Age cannot be blank/empty");
		}
		if (p.getGender() == null || "".equals(p.getGender().trim())) {
			throw new ValidatorException("Gender cannot be blank/empty");
		}
		if (p.getAddress() == null || "".equals(p.getAddress().trim())) {
			throw new ValidatorException("Address cannot be blank/empty");
		}
		if (p.getPhoneNumber() == null || "".equals(p.getPhoneNumber().trim())) {
			throw new ValidatorException("PhoneNumber cannot be blank/empty");
		}
		if (p.getPassword() == null || "".equals(p.getPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}

	public static void validateDoctorRegister(Doctors doc) throws ValidatorException {

		if (doc.getName() == null || "".equals(doc.getName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (doc.getGender() == null || "".equals(doc.getGender().trim())) {
			throw new ValidatorException("Gender cannot be blank/empty");
		}
		if (doc.getPhoneNumber() == null || "".equals(doc.getPhoneNumber().trim())) {
			throw new ValidatorException("PhoneNumber cannot be blank/empty");
		}
		if (doc.getPassword() == null || "".equals(doc.getPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
		if (doc.getDepartmentId() == 0) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}

	public static void validateDepartment(Departments dept) throws ValidatorException {

		if (dept.getName() == null || "".equals(dept.getName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
	}
}
