package com.lokhesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokhesh.app.entity.Admin;

public interface AdminRepo extends JpaRepository <Admin, Long> {
	
	Admin findByUsername(String username);

}
