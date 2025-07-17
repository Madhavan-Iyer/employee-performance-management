package com.example.employee_performance.repository;

import com.example.employee_performance.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
}
