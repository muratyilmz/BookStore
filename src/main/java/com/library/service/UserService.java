package com.library.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.controller.dto.UserRegistrationDto;
import com.library.model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
