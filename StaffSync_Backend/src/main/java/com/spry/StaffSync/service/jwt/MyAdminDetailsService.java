package com.spry.StaffSync.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Admin;
import com.spry.StaffSync.model.AdminPrinciple;
import com.spry.StaffSync.repository.AdminRepository;

@Service
public class MyAdminDetailsService  implements UserDetailsService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin admin=adminRepository.findByUsername(username);
		
		if(username == null) {
			throw new UsernameNotFoundException("use not fourn :: "+username);

		}
		return new AdminPrinciple(admin);
	}

}
