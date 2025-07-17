package com.example.employee_performance.repository;

import com.example.employee_performance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
@Query("SELECT DISTINCT e FROM Employee e JOIN e.department d JOIN EmployeeProject ep ON ep.employee = e JOIN ep.project p LEFT JOIN PerformanceReview pr ON " +
        " pr.employee = e WHERE (:score IS NULL OR pr.score = :score) AND (CAST(:reviewDate AS date) is NULL OR CAST(pr.reviewDate AS date) = :reviewDate) " +
        "AND  (:departments IS NULL OR d.name IN :departments) AND (:projects IS NULL OR p.name IN :projects)")
    List<Employee> filterEmployees(
            @Param("score") Integer score,
            @Param("reviewDate") Date reviewDate,
            @Param("departments") List<String> departments,
            @Param("projects") List<String> projects
    );
}
