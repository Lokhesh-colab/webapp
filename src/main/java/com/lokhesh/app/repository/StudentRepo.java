package com.lokhesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokhesh.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	Student findByUsername(String username);
	
}
