package com.example.microservices.school.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.school.school.entity.School;
import com.example.microservices.school.school.service.SchoolService;
import com.example.microservices.student.student.entity.Student;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;

	@PostMapping("/schoolregister")
	public void save(@RequestBody School school) {
		schoolService.saveSchool(school);
	}
	
	@GetMapping("/getAllSchools")
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }
	
	
	  @GetMapping("/{id}/students")
	    public List<Student> getStudents(@PathVariable Integer id) {
	        return schoolService.getStudentsBySchool(id);
	    }
}
