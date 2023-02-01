package com.employeemanager.api.services.impl;

import com.employeemanager.api.dtos.EmployeeDto;
import com.employeemanager.api.exceptions.EmployeeNotFoundException;
import com.employeemanager.api.models.Employee;
import com.employeemanager.api.repositories.EmployeeRepository;
import com.employeemanager.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());

        Employee newEmployee = employeeRepository.save(employee);

        EmployeeDto employeeResponse = new EmployeeDto();
        employeeResponse.setId(newEmployee.getId());
        employeeResponse.setFirstName(newEmployee.getFirstName());
        employeeResponse.setLastName(newEmployee.getLastName());
        employeeResponse.setPhoneNumber(newEmployee.getPhoneNumber());

        return employeeResponse;

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
       return employees.stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new EmployeeNotFoundException("Employee couldn't be found"));

        return mapToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    private EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }
}
