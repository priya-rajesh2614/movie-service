package com.movieservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.movieservice.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		return userRepository.findByEmail(emailId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
