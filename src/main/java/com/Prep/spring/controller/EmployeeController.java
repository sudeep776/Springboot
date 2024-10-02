package com.Prep.spring.controller;

import com.Prep.spring.Exception.ResourceNotFoundException;
import com.Prep.spring.models.Employee;
import com.Prep.spring.repository.EmployeeRepository;
import com.Prep.spring.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @Autowired
    private EmployeeRepository empRepo;

    @GetMapping("/all")
    private List<Employee> getEmployee(){
        return employeeservice.getEmployees();
    }

    @PostMapping("/save")
    private ResponseEntity<Object> saveEmployee(@RequestBody @Valid @Validated Employee employee, Errors errors){
        return ResponseEntity.ok().body(employeeservice.saveEmployee(employee));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeservice.getEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with the id: " + id));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteEmployeeById(@PathVariable("id")Integer id){
        employeeservice.deleteEmployeeById(id);
    }

    @PutMapping("{id}")
    private Employee updateEmployeeById(@PathVariable("id") Integer id,@RequestBody Employee employee) throws ChangeSetPersister.NotFoundException {
        return employeeservice.updateEmployeeById(employee,id);
    }

    @GetMapping("/queryemp/{id}")
    private List<Employee> getEmployeeq(@PathVariable("id") int id){
        return empRepo.getAllUsers(id);
    }

    @GetMapping("/bymethod")
    private Employee getbyMethod(@RequestParam("phone") String phone){
        return empRepo.findByPhone(phone);
    }
}
