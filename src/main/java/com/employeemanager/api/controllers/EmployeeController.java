package com.employeemanager.api.controllers;

import com.employeemanager.api.dtos.EmployeeDto;
import com.employeemanager.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployees(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PutMapping("employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Long id) {
        EmployeeDto response = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }
}
