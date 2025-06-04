package com.example.microservices.student.student.service;

import java.util.List;

import com.example.microservices.student.student.entity.Student;

public interface StudentService  {


	void register(Student student);

	List<Student> findAllStudents();

	List<Student> findAllStudentsBySchool(Integer schoolId);

}
