package com.example.microservices.school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.school.school.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
