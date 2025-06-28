package com.ghulam.loan.authservice.controller;

import com.ghulam.loan.authservice.dto.LoginDto;
import com.ghulam.loan.authservice.dto.SignupDto;
import com.ghulam.loan.authservice.model.Applicant;
import com.ghulam.loan.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDto signupDto) {
        Applicant saved = authService.signup(signupDto);
        return ResponseEntity.ok().body(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        var result = authService.login(loginDto);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify() {
        return null;
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resend() {
        return null;
    }
}
