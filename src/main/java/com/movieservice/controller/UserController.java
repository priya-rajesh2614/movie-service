package com.movieservice.controller;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.movieservice.dto.LoginRequestDto;
import com.movieservice.dto.UserRegistrationDTO;
import com.movieservice.entity.User;
import com.movieservice.service.UserService;

@RestController
@RequestMapping("auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest){
        try {
            String token = userService.authenticate(loginRequest);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
    

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        String response = userService.registerUser(userRegistrationDTO);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/me")
    public Map<String, Object> getUserDetails(@AuthenticationPrincipal User user) {
        return Map.of(
            "email", user.getEmail(),
            "isAdmin", user.getIsAdmin(),
            "username",user.getName()
        );
    }
}
