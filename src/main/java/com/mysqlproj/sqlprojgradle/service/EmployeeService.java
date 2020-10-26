package com.mysqlproj.sqlprojgradle.service;

import com.mysqlproj.sqlprojgradle.entitiy.Employee;
import com.mysqlproj.sqlprojgradle.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    //for post method
    public Employee saveEmployee (Employee employee){
        return  repository.save(employee);
    }
    //for save all employee
    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }

    //for get methods
    public List<Employee> getEmployee(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    //for fetching by name

    public Employee getEmployeeByName(String name){
        return repository.findByName(name);
    }

    //for delete the employee
    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee deleted !!"+id;
    }

    //for update
    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        return repository.save(existingEmployee);

    }

    //for delete


}
