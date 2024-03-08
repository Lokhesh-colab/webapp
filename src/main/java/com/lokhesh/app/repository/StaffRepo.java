package com.lokhesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokhesh.app.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Long>{
	
	Staff findByStaffusername(String staffusername);

}
