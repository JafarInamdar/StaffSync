package com.spry.StaffSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spry.StaffSync.model.Department;
import com.spry.StaffSync.model.Employee;
import com.spry.StaffSync.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return employeeService.getEmployeeById(id).map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		try {
			Employee updatedEmployee = employeeService.updateEmployee(id, employee);
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
        try {
        	employeeService.deleteEmployee(id);
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (RuntimeException e) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable("departmentId") long departmentId) {
		List<Employee> employees=employeeService.getEmployeesByDepartment(departmentId);
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/designation/{designationId}")
	public ResponseEntity<List<Employee>> getEmployeeByDesignation(@PathVariable("designationId")  long designationId) {
		List<Employee> employees=employeeService.getEmployeesByDesignation(designationId);
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
}
