package com.spry.StaffSync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;

	private String employeeFirstName;
	private String employeeLastName;
	private String employeeEmail;
	private String employeePhoneNumber;
	private String employeeAddress;
	private String employeeDateOfJoining;
	private Double employeeSalary;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designation_id")
	private Designation designation;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeDateOfJoining() {
		return employeeDateOfJoining;
	}

	public void setEmployeeDateOfJoining(String employeeDateOfJoining) {
		this.employeeDateOfJoining = employeeDateOfJoining;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Employee(long employeeId, String employeeFirstName, String employeeLastName, String employeeEmail,
			String employeePhoneNumber, String employeeAddress, String employeeDateOfJoining, Double employeeSalary,
			Department department, Designation designation) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.employeePhoneNumber = employeePhoneNumber;
		this.employeeAddress = employeeAddress;
		this.employeeDateOfJoining = employeeDateOfJoining;
		this.employeeSalary = employeeSalary;
		this.department = department;
		this.designation = designation;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
