package com.movieservice.service;


import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieservice.dto.LoginRequestDto;
import com.movieservice.dto.UserRegistrationDTO;
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
		 Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
	        if (user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
	            return jwtUtil.generateToken(user.get().getEmail());
	        } else {
	            throw new RuntimeException("Invalid email or password");
	        }
	}
	

    public String registerUser(UserRegistrationDTO userRegistrationDTO) {
        Optional<User> existingUser = userRepository.findByEmail(userRegistrationDTO.getEmail());
        if (existingUser.isPresent()) {
            return "Email already in use";
        }

        String encryptedPassword = passwordEncoder.encode(userRegistrationDTO.getPassword());

        User newUser = new User();
        newUser.setEmail(userRegistrationDTO.getEmail());
        newUser.setPassword(encryptedPassword);
        newUser.setName(userRegistrationDTO.getName());

        userRepository.save(newUser);

        return "User registered successfully";
    }
}


