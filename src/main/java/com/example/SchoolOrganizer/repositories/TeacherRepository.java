package com.example.SchoolOrganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	
	List<Teacher> findAll();
}
