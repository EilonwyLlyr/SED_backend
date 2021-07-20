package com.calstate.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.calstate.models.User;

public interface UserDAO extends MongoRepository<User, String>{
	
	public Optional<User> findByEmail(String email);
	
	public boolean existsByEmail(String email);
}
