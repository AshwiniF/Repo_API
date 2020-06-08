package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.Dao.EmployeeDAO;
import com.jbk.entity.Employee;

@Service
public class EmployeeServiceHibernate implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employedao;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employedao.findAll();
	}

	@Override
	@Transactional
	public Employee findByid(int theId) { 
		return employedao.findByid(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employedao.save(theEmployee);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		employedao.delete(theId);

	}

}
