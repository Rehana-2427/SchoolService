package com.example.microservices.student.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.student.student.entity.Student;
import com.example.microservices.student.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public void studentRegister(@RequestBody Student student) {
		studentService.register(student);

	}

	@GetMapping
	public ResponseEntity<List<Student>> findAllStudents() {
		  return ResponseEntity.ok(studentService.findAllStudents());
	}
	
	
	@GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
