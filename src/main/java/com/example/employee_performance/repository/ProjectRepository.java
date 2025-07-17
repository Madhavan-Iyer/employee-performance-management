package com.example.employee_performance.repository;

import com.example.employee_performance.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
