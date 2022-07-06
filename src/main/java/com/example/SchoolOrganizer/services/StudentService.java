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
	
	@Autowired
	private SchoolService schoolService;
	
	
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
	
	public Student update(Student Student) {
		return this.repository.save(Student);
	}
	
	public boolean setSchool(Long schoolId, Long studentId) {
		
		Student student = this.retrieve(studentId);
		
		student.setSchool(this.schoolService.retrieve(schoolId));
		
		this.update(student); // don't forget to save!
		
		return true;
	}
	
	public boolean unsetSchool(Long schoolId, Long studentId) {
		
		Student student = this.retrieve(studentId);
		
		student.setSchool(null);
		
		this.update(student); // don't forget to save!
		
		return true;
		
	}
}
