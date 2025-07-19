package com.example.employee_performance.controller;

import com.example.employee_performance.dto.EmployeeDetailsDTO;
import com.example.employee_performance.dto.EmployeeFilteredDTO;
import com.example.employee_performance.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}/details")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable Long id) {
        try {
            EmployeeDetailsDTO detailsDTO = employeeService.getEmployeeDetails(id);
            return ResponseEntity.ok(detailsDTO);
        } catch (Exception exception) {
            log.error("Exception while fetching employee details: ", exception);
            return ResponseEntity.internalServerError().body("Unexpected error: " + exception.getMessage());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterEmployees(
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date reviewDate,
            @RequestParam(required = false) List<String> departments,
            @RequestParam(required = false) List<String> projects) {
        try {
            List<EmployeeFilteredDTO> detailsDTOList = employeeService.filterEmployees(score, reviewDate, departments, projects);
            return ResponseEntity.ok(detailsDTOList);
        } catch (Exception exception) {
            log.error("Exception while fetching employee details with filters: ", exception);
            return ResponseEntity.internalServerError().body("Unexpected error: " + exception.getMessage());
        }
    }

}
