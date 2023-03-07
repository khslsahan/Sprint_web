package com.hsenid.employee.service;

import com.hsenid.employee.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Service
public class EmployeeService {

    private List<Employee> employees;

    @PostConstruct
    public void init() {
        System.out.println("The EmployeeService PostConstructor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmployeeService Employees are being destroyed.");
    }




    public List<String> fetchEmployee() {
        List<String> employeeNames = new ArrayList<String>();
        employees = new ArrayList<>();
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext( "employees.xml");
        employees.add((Employee) context.getBean("employee-1"));
        employees.add((Employee) context.getBean("employee-2"));
        employees.add((Employee) context.getBean("employee-3"));

        for (Employee employee:employees){
            employeeNames.add(employee.getName());
        }

        System.out.println(employeeNames);

        context.close();
        return employeeNames;
    }
}
