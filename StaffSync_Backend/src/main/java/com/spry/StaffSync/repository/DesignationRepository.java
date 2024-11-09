package com.spry.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spry.StaffSync.model.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

}
