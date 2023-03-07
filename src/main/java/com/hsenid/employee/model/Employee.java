package com.hsenid.employee.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {

    private String  name;
    private String  department;
    private String  salary;

    public Employee() {
    }

    public Employee(String name, String department, String salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @PostConstruct
    public void init() {
        System.out.println("The Employee  PostConstructor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee  Employees are being destroyed.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
