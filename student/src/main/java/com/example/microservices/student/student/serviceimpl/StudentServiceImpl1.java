package com.example.microservices.student.student.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.student.student.entity.Student;
import com.example.microservices.student.student.repo.StudentRepository;
import com.example.microservices.student.student.service.StudentService;

@Service
public class StudentServiceImpl1 implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void register(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findAllStudentsBySchool(Integer schoolId) {
		// TODO Auto-generated method stub
		 return studentRepository.findAllBySchoolId(schoolId);
	}


}
