package io.javabrains.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
