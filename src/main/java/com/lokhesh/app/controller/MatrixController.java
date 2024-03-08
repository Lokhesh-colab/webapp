package com.lokhesh.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokhesh.app.entity.Staff;
import com.lokhesh.app.entity.Student;
import com.lokhesh.app.loginrequest.LoginRequest;
import com.lokhesh.app.repository.AdminRepo;
import com.lokhesh.app.repository.StaffRepo;
import com.lokhesh.app.repository.StudentRepo;
import com.lokhesh.app.entity.Admin;




@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MatrixController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setAddress(updatedStudent.getAddress());
            existingStudent.setMobileno(updatedStudent.getMobileno());
            existingStudent.setUsername(updatedStudent.getUsername());
            existingStudent.setPassword(updatedStudent.getPassword());
            existingStudent.setRegno(updatedStudent.getRegno());
            Student savedStudent = studentRepo.save(existingStudent);
            return ResponseEntity.ok(savedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepo.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
	
	@PostMapping("/staff")
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff savedStaff = staffRepo.save(staff);
        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
    }
	@DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffRepo.deleteById(id);
    }
	
	
	@PostMapping("/studentlogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Student student = studentRepo.findByUsername(loginRequest.getUsername());
        if (student != null && student.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

	@Autowired
	private StaffRepo staffRepo;
	@PostMapping("/stafflogin")
    public ResponseEntity<?> stafflogin(@RequestBody LoginRequest loginRequest) {
        Staff staff = staffRepo.findByStaffusername(loginRequest.getStaffusername());
        if (staff != null && staff.getStaffpassword().equals(loginRequest.getStaffpassword())) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
	@PutMapping("/updateStaffs/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        Staff existingStaff = staffRepo.findById(id).orElse(null);
        if (existingStaff != null) {
        	existingStaff.setStaffusername(updatedStaff.getStaffusername());
        	existingStaff.setMobile(updatedStaff.getMobile());
        	existingStaff.setRole(updatedStaff.getStaffpassword());
            Staff savedStaff = staffRepo.save(existingStaff);
            return ResponseEntity.ok(savedStaff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@GetMapping("/staffs")
	public List<Staff> getAllStaffs() {
		
		return staffRepo.findAll();
	}

    
	@GetMapping("/staff/{id}")
    public ResponseEntity<Optional<Staff>> staff(@PathVariable Long id) {
        Optional<Staff> staff = staffRepo.findById(id);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@Autowired
	private AdminRepo adminRepo;
	@PostMapping("/adminlogin")
    public ResponseEntity<?> adminlogin(@RequestBody LoginRequest loginRequest) {
        Admin admin = adminRepo.findByUsername(loginRequest.getUsername());
        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
