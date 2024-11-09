package com.spry.StaffSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Admin;
import com.spry.StaffSync.model.AdminPrinciple;
import com.spry.StaffSync.repository.AdminRepository;

@Service
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminPrinciple loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUsername(username);
		if (admin == null) {
			System.out.println(("Admin not found with username ::" + username));
			throw new UsernameNotFoundException("admin not found :: " + username);

		}
		return new AdminPrinciple(admin);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
