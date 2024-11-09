package com.spry.StaffSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spry.StaffSync.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	   List<Employee> findByDesignation_DesignationId(Long designationId);

	    List<Employee> findByDepartment_DepartmentId(Long departmentId);
}
