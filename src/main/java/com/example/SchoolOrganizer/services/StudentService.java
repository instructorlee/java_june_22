package com.example.SchoolOrganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolOrganizer.models.Student;
import com.example.SchoolOrganizer.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public List<Student> all() {
		return this.repository.findAll();
	}
	
	public Student create(Student item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Student retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Student update(Student student) {
		return this.repository.save(student);
	}
}
