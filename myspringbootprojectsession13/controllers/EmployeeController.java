package com.example.myspringbootprojectsession13.controllers;

import com.example.myspringbootprojectsession13.entities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private static final List<Employee> EMPLOYEES = List.of(
            new Employee(1L, "Nguyen Van An", 15_000_000),
            new Employee(2L, "Tran Thi Binh", 18_500_000),
            new Employee(3L, "Le Van Cuong", 22_000_000)
    );

    @GetMapping
    public List<Employee> getEmployees() {
        return EMPLOYEES;
    }
}
