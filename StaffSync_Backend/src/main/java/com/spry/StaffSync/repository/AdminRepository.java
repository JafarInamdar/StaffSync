package com.spry.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spry.StaffSync.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByUsername(String username);

}
