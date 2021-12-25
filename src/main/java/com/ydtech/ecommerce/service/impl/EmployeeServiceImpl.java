package com.ydtech.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ydtech.ecommerce.exception.ResourceNotFoundException;
import com.ydtech.ecommerce.model.Employee;
import com.ydtech.ecommerce.repository.EmployeeRepository;
import com.ydtech.ecommerce.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {

		Employee emp = employeeRepository.getById(id);

		return Optional.of(emp).orElseThrow(() ->

		new ResourceNotFoundException("Employee", "Id", id));

		// Employee employee = employeeRepository.getById(id);
		// return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {

		Employee existingEmployee = employeeRepository.getById(id);

		if (Optional.of(existingEmployee).isPresent()) {

			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());

			employeeRepository.saveAndFlush(existingEmployee);

			return existingEmployee;

		} else {

			employeeRepository.saveAndFlush(employee);

			return employee;
		}

	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

}
