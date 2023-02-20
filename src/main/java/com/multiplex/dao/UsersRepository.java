package com.multiplex.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.User;


public interface UsersRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	User findByEmailId(String email);
	public User findByEmailIdAndPassword(String emailId,String password);
	
}