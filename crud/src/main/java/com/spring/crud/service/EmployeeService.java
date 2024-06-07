package com.spring.crud.service;

import java.util.List;

import com.spring.crud.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> fetchAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployeeById(Long id, Employee employee);

	String deleteDepartmentById(Long id);

}
