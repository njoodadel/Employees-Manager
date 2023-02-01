package com.employeemanager.api.services;

import com.employeemanager.api.dtos.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
