package com.Prep.spring.models;

import com.Prep.spring.validator.PhoneNumberValidator;
import com.Prep.spring.validator.VaildateEmployeeType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @PhoneNumberValidator(message="phone number invalid")
    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @VaildateEmployeeType(message="invalid employee type")
    @Column(name = "type")
    private String employeeType;
}
