package com.ketan.library.controller;

import com.ketan.library.entity.User;
import com.ketan.library.repository.UserRepository;
import com.ketan.library.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existing = userRepository.findByUsername(user.getUsername());

        if (existing != null &&
                passwordEncoder.matches(user.getPassword(), existing.getPassword())) {

            return jwtUtil.generateToken(existing.getUsername(), existing.getRole());
        }

        return "Invalid credentials";
    }
}
