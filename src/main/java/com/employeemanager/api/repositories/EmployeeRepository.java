package com.employeemanager.api.repositories;

import com.employeemanager.api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
