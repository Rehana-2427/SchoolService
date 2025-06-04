package com.example.microservices.school.school.service;

import java.util.List;

import com.example.microservices.school.school.entity.School;
import com.example.microservices.student.student.entity.Student;

public interface SchoolService {

	void saveSchool(School school);

	List<School> findAllSchools();

	List<Student> getStudentsBySchool(Integer id);
	
	

}
