package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "EmployeePayrollTable")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@NotNull(message = "Name can not be null!")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$", message = "Employee Name is invalid!")
    private String name;
    private String password;
    @Min(value = 50000, message = "Please provide more then 50000 salary!")
    private Long salary;

    @ElementCollection
    @CollectionTable(
            name = "rolestab" ,joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "role")
    private Set<String> roles;


}

