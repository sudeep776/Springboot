package com.Prep.spring.service;

import com.Prep.spring.exception.ResourceNotFoundException;
import com.Prep.spring.models.Employee;
import com.Prep.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(Employee employee,Integer id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmployeeType(employee.getEmployeeType());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
