package com.example.SchoolOrganizer.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	@Query(value = "SELECT COUNT(id) FROM users", nativeQuery = true)
	int getCount();
}
