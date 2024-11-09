package com.spry.StaffSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spry.StaffSync.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("SELECT d FROM Department d WHERE LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) "
			+ "OR LOWER(d.departmentDescription) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Department> searchDepartments(@Param("keyword") String keyword);

}
