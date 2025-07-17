package com.example.employee_performance.bootstrap;

import com.example.employee_performance.model.*;
import com.example.employee_performance.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Component
public class EmployeeDataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepo;
    private final EmployeeRepository employeeRepo;
    private final ProjectRepository projectRepo;
    private final PerformanceReviewRepository reviewRepo;
    private final EmployeeProjectRepository employeeProjectRepo;

    public EmployeeDataLoader(DepartmentRepository departmentRepo,
                              EmployeeRepository employeeRepo,
                              ProjectRepository projectRepo,
                              PerformanceReviewRepository reviewRepo,
                              EmployeeProjectRepository employeeProjectRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
        this.projectRepo = projectRepo;
        this.reviewRepo = reviewRepo;
        this.employeeProjectRepo = employeeProjectRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Departments
        Department eng = new Department("Engineering", 500000.0);
        Department hr = new Department("Human Resources", 200000.0);
        if (departmentRepo.count() == 0) {
            departmentRepo.save(eng);
            departmentRepo.save(hr);
        }

        // Employees
        Employee manager = new Employee("Alice", "alice@example.com", eng,
                date(2020, 1, 15), 120000.0, null);

        Employee emp1 = new Employee("Bob", "bob@example.com", eng,
                date(2021, 3, 10), 80000.0, manager);
        Employee emp2 = new Employee("Charlie", "charlie@example.com", hr,
                date(2022, 5, 5), 75000.0, manager);
        if (employeeRepo.count() == 0) {
            employeeRepo.save(manager);
            employeeRepo.save(emp1);
            employeeRepo.save(emp2);
        }

        // Projects
        Project proj1 = new Project("Employee Dashboard", date(2023, 1, 1),
                date(2023, 12, 31), eng);
        Project proj2 = new Project("HR Dashboard", date(2023, 6, 1),
                date(2024, 5, 31), hr);
        if (projectRepo.count() == 0) {
            projectRepo.save(proj1);
            projectRepo.save(proj2);
        }

        // Performance Reviews
        if (reviewRepo.count() == 0) {
            reviewRepo.save(new PerformanceReview(emp1, date(2023, 12, 15),
                    8, "Consistent and reliable"));
            reviewRepo.save(new PerformanceReview(emp2, date(2023, 12, 20),
                    9, "Great collaboration skills"));
        }

        // Employee-Project Assignments
        EmployeeProject ep1 = new EmployeeProject(emp1, proj1,
                date(2023, 1, 10), "Backend Developer");
        EmployeeProject ep2 = new EmployeeProject(emp2, proj2,
                date(2023, 6, 5), "HR Analyst");

        if (employeeProjectRepo.count() == 0) {
            employeeProjectRepo.save(ep1);
            employeeProjectRepo.save(ep2);
        }

        System.out.println("Pre-loaded employee data on start up successfully.");
    }

    private Date date(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}