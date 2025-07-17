package com.example.employee_performance.dto;

import java.util.List;

public class EmployeeFilteredDTO {
    private long id;
    private String name;
    private String email;
    private String department;
    private String dateOfJoining;
    private List<String> projects;
    private String manager;

    public EmployeeFilteredDTO(long id, String name, String email, String department, List<String> projects, String dateOfJoining, String manager) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.projects = projects;
        this.dateOfJoining = dateOfJoining;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
