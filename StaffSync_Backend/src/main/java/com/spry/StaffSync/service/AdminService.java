package com.spry.StaffSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Admin;
import com.spry.StaffSync.repository.AdminRepository;
import com.spry.StaffSync.service.jwt.JwtUtil;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired 
	private JwtUtil jwtUtil;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	
	public Admin registerAdmin(Admin admin) {
		admin.setPassword(encoder.encode(admin.getPassword()));
		return adminRepository.save(admin);
	}
	
	public String verify(Admin admin) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtUtil.generateToken(admin.getUsername());
		}else {
			return "fail";
		}
	}

}
