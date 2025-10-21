package com.global.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employee;
import com.global.hr.repository.IEmpRepo;

@Component
public class DbCheckRunner implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IEmpRepo repo;

    @Override
    public void run(String... args) throws Exception {
    	   // Drop table if exists
        jdbcTemplate.execute("""
            IF OBJECT_ID('hrdb.dbo.employee', 'U') IS NOT NULL
                DROP TABLE hrdb.dbo.employee;
        """);

        // Recreate table
        jdbcTemplate.execute("""
            CREATE TABLE hrdb.dbo.employee (
                id INT NOT NULL PRIMARY KEY,
                name VARCHAR(45) NULL,
                salary FLOAT NULL
            );
        """);
    	
    	if(repo.count()==0) {
    	repo.insert(new Employee(1L, "Ali Kotb", 8000.0));
    	repo.insert(new Employee(2L, "Sara Ahmed", 9500.0));
    	repo.insert(new Employee(3L, "Omar Hassan", 7000.0));
    	repo.insert(new Employee(4L, "Mona Youssef", 12000.0));
    	repo.insert(new Employee(5L, "Hassan Adel", 6500.0));
    	repo.insert(new Employee(6L, "Laila Mostafa", 11000.0));
    	repo.insert(new Employee(7L, "Tarek Nabil", 9000.0));
    	}
    }
}

