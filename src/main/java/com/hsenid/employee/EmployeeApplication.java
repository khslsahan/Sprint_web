package com.hsenid.employee;

import com.hsenid.employee.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
//		System.out.println("Hello World");

		SpringApplication.run(EmployeeApplication.class, args);

		EmployeeService employeeService =  new EmployeeService();
		employeeService.fetchEmployee();

//		context.close();
	}

}
