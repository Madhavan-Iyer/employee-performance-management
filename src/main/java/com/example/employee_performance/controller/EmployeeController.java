package com.example.employee_performance.controller;

import com.example.employee_performance.dto.EmployeeDetailsDTO;
import com.example.employee_performance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}/details")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable Long id) {
        try {
            EmployeeDetailsDTO detailsDTO = employeeService.getEmployeeDetails(id);
            return ResponseEntity.ok(detailsDTO);
        } catch (Exception exception) {
            System.out.println("Exception while fetching employee details: ");
            exception.printStackTrace();
            return ResponseEntity.internalServerError().body("Unexpected error: " + exception.getMessage());
        }
    }
}
