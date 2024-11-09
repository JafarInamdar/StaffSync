package com.spry.StaffSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.spry.StaffSync.model.Designation;
import com.spry.StaffSync.service.DesignationService;

@RestController
@RequestMapping("/api/designations")
@CrossOrigin(origins = "http://localhost:3000")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping
	public ResponseEntity<List<Designation>> getAllDesignations() {
		List<Designation> designations = designationService.getAllDesignations();
		return new ResponseEntity<>(designations, HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<Designation> getDesignationById(@PathVariable("id") long id) {
		return designationService.getDesignationById(id)
				.map(designation -> new ResponseEntity<>(designation, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Designation> addDesignation(@Validated @RequestBody Designation designation) {
		Designation savedDesignation = designationService.addDesignation(designation);
		return new ResponseEntity<>(savedDesignation, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Designation> updateDesignation(@Validated @PathVariable("id") long id,
			@RequestBody Designation designation) {
		try {
			Designation updatedDesignation = designationService.updateDesignation(id, designation);
			return new ResponseEntity<>(updatedDesignation, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDesignation(@PathVariable("id") long id) {
		try {
			designationService.deleteDesignation(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
