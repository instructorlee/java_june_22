package com.example.SchoolOrganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.SchoolOrganizer.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
	
	List<Address> findAll();
}
