package com.spry.StaffSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spry.StaffSync.model.Admin;
import com.spry.StaffSync.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return adminService.registerAdmin(admin);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Admin admin) {
		System.out.println("Login"+ admin);
	  return adminService.verify(admin);	
	}

}
