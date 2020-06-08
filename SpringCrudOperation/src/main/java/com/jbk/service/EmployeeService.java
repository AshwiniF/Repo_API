package com.jbk.service;

import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findByid(int theId);
	public void save(Employee theEmployee);
	public void delete(int theId);
}
