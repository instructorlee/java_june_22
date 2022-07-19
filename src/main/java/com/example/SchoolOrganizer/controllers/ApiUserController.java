package com.example.SchoolOrganizer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SchoolOrganizer.models.Teacher;
import com.example.SchoolOrganizer.models.User;
import com.example.SchoolOrganizer.services.StudentService;
import com.example.SchoolOrganizer.services.TeacherService;
import com.example.SchoolOrganizer.services.UserService;

@RestController
@RequestMapping("api/user")
public class ApiUserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public ResponseEntity<List<User>>  all( Model model, HttpSession session) {
		return ResponseEntity.status(200).body(this.service.all());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> retrieve(@PathVariable Long id) {
		return ResponseEntity.status(200).body(this.service.retrieve(id));
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		this.service.delete(id);
		return ResponseEntity.status(200).body(null);
	}
	
	@PostMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.status(200).body(this.service.update(user));
	}
	
}
