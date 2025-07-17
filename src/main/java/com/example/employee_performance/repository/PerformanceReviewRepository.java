package com.example.employee_performance.repository;

import com.example.employee_performance.model.Employee;
import com.example.employee_performance.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
    List<PerformanceReview> findTop3ByEmployeeOrderByReviewDateDesc(Employee employee);
}
