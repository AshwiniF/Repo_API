package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emps")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	@RequestMapping("/emps/{id}")
	public Employee getEmployee(@PathVariable int id){
		Employee emp= employeeService.findByid(id);
		
		if(emp==null) {
			throw new RuntimeException("Employee id is not found"+ id);
		}else
			return emp;
	}
	@RequestMapping(value = "/emps",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
		
	}
	@RequestMapping(value = "/emps",method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
		
	}
	@RequestMapping(value = "/emps/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable int id) {
		Employee tempEmps=employeeService.findByid(id);
		if(tempEmps==null) {
			throw new RuntimeException("employee id is not found"+id);
		}
		employeeService.delete(id);
		return "employee deleted" +id;
		
	}
}
