package com.Prep.spring.service;

import com.Prep.spring.models.Employee;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee saveEmployee(Employee employee);

    public Optional<Employee> getEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);
    public Employee updateEmployeeById(Employee employee,Integer id);
}
