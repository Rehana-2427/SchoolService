package com.example.microservices.school.school.fiegnclientinterface;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

//	@GetMapping("/school/{school-id}")
//	List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}
