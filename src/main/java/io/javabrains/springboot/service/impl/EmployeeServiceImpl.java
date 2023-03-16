package io.javabrains.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springboot.exception.ResourceNotFoundException;
import io.javabrains.springboot.model.Employee;
import io.javabrains.springboot.repository.EmployeeRepository;
import io.javabrains.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));	
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}

}
