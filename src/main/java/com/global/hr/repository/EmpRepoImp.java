package com.global.hr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
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
		
		return jdbcTemplate.queryForObject("select id, name, salary from employee where id = ?",
				new Object[] {id},
				new EmployeeMapper()
				);
	}

	@Override
	public int insert(Employee emp) {
		
		return jdbcTemplate.update("insert into employee (id, name, salary) values (?, ? ,?)", new Object[] {emp.getId(),emp.getName(),emp.getSalary()});
	}

	@Override
	public int update(Employee emp) {
		
		return jdbcTemplate.update("update employee set name=? , salary=? where id = ?", new Object[] {emp.getName(),emp.getSalary(),emp.getId()});
	}

	@Override
	public int delete(Long id) {
		
		return jdbcTemplate.update("delete from employee where id=?", new Object[] {id});
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select id, name, salary from employee", new EmployeeMapper());
	}

}
