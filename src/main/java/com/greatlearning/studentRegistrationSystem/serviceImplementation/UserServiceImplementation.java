package com.greatlearning.studentRegistrationSystem.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.studentRegistrationSystem.entity.User;
import com.greatlearning.studentRegistrationSystem.repository.UserRepo;
import com.greatlearning.studentRegistrationSystem.security.MyUserDetails;

public class UserServiceImplementation implements UserDetailsService{

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.getUserByUsername(username); 
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		} 
		
		return new MyUserDetails(user);
	}
}
