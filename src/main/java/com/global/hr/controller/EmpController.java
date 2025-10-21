package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.model.Employee;
import com.global.hr.repository.IEmpRepo;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private IEmpRepo repo;
	
	@GetMapping("/count")
	public int countEmployees() {
		return repo.count();
	}
	
	@GetMapping("/get-employee{id}")
	public Employee findById(@PathVariable Long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/get-all")
	public List<Employee> findAll() {
		return repo.findAll();
	}
	
	
}
