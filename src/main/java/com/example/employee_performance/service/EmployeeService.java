package com.example.employee_performance.service;

import com.example.employee_performance.dto.EmployeeDetailsDTO;
import com.example.employee_performance.dto.EmployeeFilteredDTO;
import com.example.employee_performance.dto.PerformanceReviewDTO;
import com.example.employee_performance.model.Employee;
import com.example.employee_performance.model.PerformanceReview;
import com.example.employee_performance.repository.EmployeeRepository;
import com.example.employee_performance.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    public EmployeeDetailsDTO getEmployeeDetails(long id) throws Exception {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee with id: " + id + " not found."));

        EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment().getName());

        List<String> projectNames = employee.getEmployeeProjects().stream().map(emp -> emp.getProject().getName()).collect(Collectors.toList());
        dto.setProjects(projectNames);

        List<PerformanceReviewDTO> previous3 = performanceReviewRepository.findTop3ByEmployeeOrderByReviewDateDesc(employee)
                .stream().map(review -> {
                    PerformanceReviewDTO reviewDTO = new PerformanceReviewDTO();
                    reviewDTO.setReviewDate(review.getReviewDate().toString());
                    reviewDTO.setComments(review.getReviewComments());
                    reviewDTO.setRating(review.getScore());
                    return reviewDTO;
                }).collect(Collectors.toList());
        dto.setPrevious3Reviews(previous3);
        return dto;
    }

    public List<EmployeeFilteredDTO> filterEmployees(Integer score, Date reviewDate, List<String> departments, List<String> projects) {
        List<Employee> employees = employeeRepository.filterEmployees(score, reviewDate, departments, projects);

        return employees.stream().map(e -> {
                    List<String> projectNames = e.getEmployeeProjects().stream()
                            .map(ep -> ep.getProject().getName())
                            .collect(Collectors.toList());
                    return new EmployeeFilteredDTO(e.getId(), e.getName(), e.getEmail(), e.getDepartment().getName(), projectNames, e.getDateOfJoining().toString(), e.getManager().getName()){};
                }).collect(Collectors.toList());
    }
}
