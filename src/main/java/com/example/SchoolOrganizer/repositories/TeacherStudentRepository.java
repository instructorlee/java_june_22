package com.example.SchoolOrganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.TeacherStudent;

public interface TeacherStudentRepository extends CrudRepository<TeacherStudent, Long> {
	
	List<TeacherStudent> findAll();
	
	TeacherStudent findByTeacherIdAndStudentId(Long teacherId, Long studentId);
}
