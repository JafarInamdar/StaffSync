package com.spry.StaffSync.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long departmentId;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "departmentName is Mendatory")
	@Size(min = 5, message = "Department name must be at least 5 characters")
	@Size(max = 50, message = "Department name must not exceed 50 characters")
	private String departmentName;

	@Column(length = 500)
	@NotBlank(message = "Department description is mandatory")
	@Size(min = 5, message = "Department name must be at least 5 characters")
	@Size(max = 50, message = "Department name must not exceed 50 characters")
	private String departmentDescription;

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public Department(long departmentId, String departmentName, String departmentDescription) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
	}

	public Department() {
		super();
	}

}
