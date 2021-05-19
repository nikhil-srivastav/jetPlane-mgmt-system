package com.bth.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bth.springboot.dto.UserRegistrationDto;
import com.bth.springboot.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
