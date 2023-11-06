package com.greatlearning.studentRegistrationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.studentRegistrationSystem.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{ 

	@Query("SELECT u FROM User u WHERE u.username=?1")
	public User getUserByUsername(String username);
}
