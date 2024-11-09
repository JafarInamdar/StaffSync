package com.spry.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Employee;
import com.spry.StaffSync.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(long id, Employee employee) {
        Optional<Employee> oldEmployeeOptional = employeeRepository.findById(id);

        if (oldEmployeeOptional.isPresent()) {
            Employee oldEmployee = oldEmployeeOptional.get();
            oldEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
            oldEmployee.setEmployeeLastName(employee.getEmployeeLastName());
            oldEmployee.setEmployeeEmail(employee.getEmployeeEmail());
            oldEmployee.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
            oldEmployee.setEmployeeAddress(employee.getEmployeeAddress());
            oldEmployee.setEmployeeDateOfJoining(employee.getEmployeeDateOfJoining());
            oldEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            oldEmployee.setDepartment(employee.getDepartment());
            oldEmployee.setDesignation(employee.getDesignation());
            return employeeRepository.save(oldEmployee); 
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public void deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public List<Employee> getEmployeesByDepartment(long departmentId) {
        return employeeRepository.findByDepartment_DepartmentId(departmentId);
    }

    public List<Employee> getEmployeesByDesignation(long designationId) {
        return employeeRepository.findByDesignation_DesignationId(designationId);
    }
}
