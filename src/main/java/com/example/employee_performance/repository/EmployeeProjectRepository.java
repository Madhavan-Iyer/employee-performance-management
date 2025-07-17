package com.example.employee_performance.repository;

import com.example.employee_performance.model.EmployeeProject;
import com.example.employee_performance.model.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {
}
