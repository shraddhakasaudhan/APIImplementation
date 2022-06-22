package com.springboot.backend2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend2.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	

}
