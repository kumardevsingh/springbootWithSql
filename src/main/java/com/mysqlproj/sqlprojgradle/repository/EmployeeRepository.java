package com.mysqlproj.sqlprojgradle.repository;

import com.mysqlproj.sqlprojgradle.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
}
