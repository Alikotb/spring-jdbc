package com.global.hr.repository;

import java.util.List;

import com.global.hr.model.Employee;

public interface IEmpRepo {
	
	int count();
	Employee findById(Long id);
	Employee insert(Employee emp);
	int update(Employee emp);
	int delete(Long id);
	List<Employee> findAll();

}
