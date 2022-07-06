package com.example.SchoolOrganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolOrganizer.models.Address;
import com.example.SchoolOrganizer.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	
	public List<Address> all() {
		return this.repository.findAll();
	}
	
	public Address create(Address item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Address retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Address update(Address Address) {
		return this.repository.save(Address);
	}
}
