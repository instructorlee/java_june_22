package com.example.SchoolOrganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
}
