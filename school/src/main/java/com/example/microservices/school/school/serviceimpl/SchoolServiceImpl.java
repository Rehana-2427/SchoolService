package com.example.microservices.school.school.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.school.school.entity.School;
import com.example.microservices.school.school.repository.SchoolRepository;
import com.example.microservices.school.school.service.SchoolService;
import com.example.microservices.student.student.entity.Student;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public void saveSchool(School school) {
		// TODO Auto-generated method stub
		schoolRepository.save(school);
	}

	@Override
	public List<School> findAllSchools() {
		// TODO Auto-generated method stub
		return schoolRepository.findAll();
	}
	
	
	  public List<Student> getStudentsBySchool(Integer schoolId) {
	        String studentServiceUrl = "http://localhost:8081/students/school/" + schoolId;
	        HttpHeaders headers = new HttpHeaders();
	        
	        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	        HttpEntity<Map<String,String>> entity = new HttpEntity<>(headers);
	        ResponseEntity<List<Student>> response = restTemplate.exchange(
	                studentServiceUrl,
	                HttpMethod.GET,
	                entity,
	                new ParameterizedTypeReference<List<Student>>() {}
	        );
	        return response.getBody();
	    }

}
