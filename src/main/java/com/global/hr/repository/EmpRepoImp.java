package com.global.hr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employee;

@Component
public class EmpRepoImp implements IEmpRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		
		return jdbcTemplate.queryForObject("select COUNT(*) from employee", Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
