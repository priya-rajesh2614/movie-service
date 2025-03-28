package com.movieservice.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieservice.dto.LoginRequestDto;
import com.movieservice.entity.User;
import com.movieservice.json.JwtUtil;
import com.movieservice.repository.UserRepository;

@Service
public class UserService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(JwtUtil jwtUtil, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    

	public String authenticate(LoginRequestDto loginRequest) {
		 User user = userRepository.findByEmail(loginRequest.getEmail());
	        if (user != null && loginRequest.getPassword().equals(user.getPassword())) {
	            return jwtUtil.generateToken(user.getEmail());
	        } else {
	            throw new RuntimeException("Invalid email or password");
	        }
	}
}


