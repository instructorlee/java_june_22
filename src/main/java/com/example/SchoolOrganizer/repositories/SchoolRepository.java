package com.example.SchoolOrganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.School;

public interface SchoolRepository extends CrudRepository<School, Long> {
	
	List<School> findAll();
}
