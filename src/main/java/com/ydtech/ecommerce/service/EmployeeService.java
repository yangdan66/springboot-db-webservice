package com.ydtech.ecommerce.service;

import java.util.List;

import com.ydtech.ecommerce.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee findEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployeeById(long id);

}
