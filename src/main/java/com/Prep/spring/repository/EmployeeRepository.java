package com.Prep.spring.repository;


import com.Prep.spring.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e where e.id=:id")
    public List<Employee> getAllUsers(int id);

    public Employee findByPhone(String phone);
}
