package com.spry.StaffSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spry.StaffSync.model.Department;
import com.spry.StaffSync.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> depatments = departmentService.getAllDepartments();
		return new ResponseEntity<>(depatments, HttpStatus.OK);
	}

	@GetMapping("/paginated")
	public ResponseEntity<Page<Department>> getAllDepartmentsWithPaggination(Pageable pageable) {
		Page<Department> depatments = departmentService.getAllDepartmentsWithPagabel(pageable);
		return new ResponseEntity<>(depatments, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
		return departmentService.getDepartmentById(id)
				.map(department -> new ResponseEntity<>(department, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Department> addDepartment(@Validated @RequestBody Department department) {
		Department savedDepartment = departmentService.addDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@Validated @PathVariable("id") long id,
			@RequestBody Department department) {
		try {
			Department updatedDepartment = departmentService.updateDepartment(id, department);
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable("id") long id) {
		try {
			departmentService.deleteDepartment(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<List<Department>> searchDepartments(@RequestParam("keyword") String keyword) {
		List<Department> departments = departmentService.searchDepartments(keyword);
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

}
