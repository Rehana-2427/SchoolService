package com.example.microservices.student.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.student.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllBySchoolId(Integer schoolId);
	

}
