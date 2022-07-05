package com.example.SchoolOrganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolOrganizer.models.School;
import com.example.SchoolOrganizer.repositories.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository repository;
	
	
	public List<School> all() {
		return this.repository.findAll();
	}
	
	public School create(School item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public School retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public School update(School School) {
		return this.repository.save(School);
	}
}
