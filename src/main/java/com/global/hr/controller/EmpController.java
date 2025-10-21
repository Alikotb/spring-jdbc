package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
