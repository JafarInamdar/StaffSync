package com.spry.StaffSync.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long designationId;

	@NotBlank(message = "designationTitle is Mendatory")
	@Size(min = 5, message = "Designation Title must be at least 5 characters")
	@Size(max = 50, message = "Designation Title must not exceed 50 characters")
	private String designationTitle;

	@NotBlank(message = "Designation Description is Mendatory")
	@Size(min = 5, message = "Designation Description must be at least 5 characters")
	@Size(max = 500, message = "Designation Description must not exceed 500 characters")
	@Column(length = 500)
	private String designationDescription;
	
	@NotBlank(message = "Designation Level is Mendatory")
	private String designationLevel;

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationTitle() {
		return designationTitle;
	}

	public void setDesignationTitle(String designationTitle) {
		this.designationTitle = designationTitle;
	}

	public String getDesignationDescription() {
		return designationDescription;
	}

	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}

	public String getDesignationLevel() {
		return designationLevel;
	}

	public void setDesignationLevel(String designationLevel) {
		this.designationLevel = designationLevel;
	}

	public Designation(long designationId, String designationTitle, String designationDescription,
			String designationLevel) {
		super();
		this.designationId = designationId;
		this.designationTitle = designationTitle;
		this.designationDescription = designationDescription;
		this.designationLevel = designationLevel;
	}

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
