package com.example.employee_performance.dto;

import java.util.List;

public class EmployeeDetailsDTO {
    private Long id;
    private String name;
    private String department;
    private List<String> projects;
    private List<PerformanceReviewDTO> previous3Reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<PerformanceReviewDTO> getPrevious3Reviews() {
        return previous3Reviews;
    }

    public void setPrevious3Reviews(List<PerformanceReviewDTO> previous3Reviews) {
        this.previous3Reviews = previous3Reviews;
    }
}
