package com.anusha.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan("com.anusha.hospital.servlet")

public class HospitalAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalAppApplication.class, args);

	}

}
