package com.Prep.spring.controller;

import com.Prep.spring.exception.AppError;
import com.Prep.spring.models.Employee;
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

    @GetMapping("/all")
    private List<Employee> getEmployee(){
        return employeeservice.getEmployees();
    }

    @PostMapping("/save")
    private ResponseEntity<Object> saveEmployee(@RequestBody @Valid @Validated Employee employee, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(AppError.builder().errorMessage(errors.getFieldError().getDefaultMessage()).errorCode("bad request").build());
       }
        return ResponseEntity.ok().body(employeeservice.saveEmployee(employee));
    }

    @GetMapping("{id}")
    private Optional<Employee> getEmployeeById(@PathVariable("id") Integer id){
        return employeeservice.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteEmployeeById(@PathVariable("id")Integer id){
        employeeservice.deleteEmployeeById(id);
    }

    @PutMapping("{id}")
    private Employee updateEmployeeById(@PathVariable("id") Integer id,@RequestBody Employee employee) throws ChangeSetPersister.NotFoundException {
        return employeeservice.updateEmployeeById(employee,id);
    }
}
