package com.springboot.backend2.service.imp;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.backend2.entity.Employee;
import com.springboot.backend2.exception.ResourceNotFoundException;
import com.springboot.backend2.repo.EmployeeRepo;
import com.springboot.backend2.service.EmployeeService;

@Service
public class EmployeeServiceimp implements EmployeeService {

	private EmployeeRepo employeeRepo;
	
	public EmployeeServiceimp(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		//Optional<Employee> employee = employeeRepo.findById(id);
		//if(employee.isPresent()) {
			//return employee.get();
		//}
		//else {
			//throw new ResourceNotFoundException("Employee", "ID", id);
		//}
		
		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
				
		
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		
		// we need to check whether employee by given id is exist in database or not
		
		Employee existingEmployee = employeeRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to database
		
		employeeRepo.save(existingEmployee);
		
		return existingEmployee;
				
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether employee is exist in database or not
		employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		employeeRepo.deleteById(id);
	}
	
	


	
}
