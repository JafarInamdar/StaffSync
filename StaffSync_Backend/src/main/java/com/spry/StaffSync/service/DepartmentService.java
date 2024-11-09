package com.spry.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Department;
import com.spry.StaffSync.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Page<Department> getAllDepartmentsWithPagabel(Pageable pageable) {
		return departmentRepository.findAll(pageable);
	}

	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department updateDepartment(long id, Department department) {
		Department oldDepartment = departmentRepository.findById(id).orElse(null);

		if (oldDepartment != null) {
			oldDepartment.setDepartmentName(department.getDepartmentName());
			oldDepartment.setDepartmentDescription(department.getDepartmentDescription());
			return departmentRepository.save(oldDepartment);
		} else {
			throw new RuntimeException("Department not found with id: " + id);
		}
	}

	public void deleteDepartment(long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		} else {
			throw new RuntimeException("Department not found with id: " + id);
		}
	}

	public Optional<Department> getDepartmentById(long departmentId) {
		return departmentRepository.findById(departmentId);
	}

	public List<Department> searchDepartments(String keyword) {
		return departmentRepository.searchDepartments(keyword);
	}

}
