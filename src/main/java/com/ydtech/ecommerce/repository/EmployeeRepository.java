package com.ydtech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ydtech.ecommerce.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
