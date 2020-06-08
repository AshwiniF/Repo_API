package com.jbk.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findByid(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee emp=currentSession.get(Employee.class, theId);
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void delete(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query query=currentSession.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", theId);
		query.executeUpdate();
		
	}

}
