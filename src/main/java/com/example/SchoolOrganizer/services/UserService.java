package com.example.SchoolOrganizer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolOrganizer.models.User;
import com.example.SchoolOrganizer.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> all() {
		return this.repository.findAll();
	}
	
	public User authenticate(User user) {
		
        Optional<User> foundUser = repository.findByEmail(user.getEmail());
        
        if (foundUser.isEmpty()) return null;
        
        if( foundUser == null || !BCrypt.checkpw(user.getPassword(), foundUser.get().getPassword()) ) return null; // bcrypt check: the order matters here
        
        return foundUser.get();
    }
	
	public User create(User user) {
		
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        
        return this.repository.save(user);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public User retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public User update(User User) {
		return this.repository.save(User);
	}
}
