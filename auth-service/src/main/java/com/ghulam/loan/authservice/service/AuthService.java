package com.ghulam.loan.authservice.service;

import com.ghulam.loan.authservice.dto.LoginDto;
import com.ghulam.loan.authservice.dto.SignupDto;
import com.ghulam.loan.authservice.enums.UserRole;
import com.ghulam.loan.authservice.model.Applicant;
import com.ghulam.loan.authservice.repo.ApplicantRepo;
import com.ghulam.loan.authservice.security.TokenService;
import com.ghulam.loan.authservice.utils.CommonUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ApplicantRepo applicantRepo;
    private final EmailService emailService;
    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Applicant signup(SignupDto signupDto) {
        Applicant applicant = getApplicant(signupDto);
        return applicantRepo.save(applicant);
    }

    public Map<String, Object> login(LoginDto loginDto) {
        final String email = loginDto.email();
        final String password = loginDto.password();

        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception ex) {
            return Map.of("message", "Invalid credentials", "reason", ex);
        }

        Applicant applicant = applicantRepo.findByEmail(email).orElse(null);
        if (applicant == null) {
            return Map.of("message", "Applicant not found");
        }

        String token = tokenService.generateToken(applicant);

        return Map.of(
                "id", applicant.getId(),
                "email", applicant.getUsername(),
                "role", applicant.getRole().toString(),
                "token", token
        );
    }


    private Applicant getApplicant(SignupDto signupDto) {
        Applicant applicant = new Applicant();
        applicant.setId(CommonUtils.uniqueId());
        applicant.setRole(UserRole.APPLICANT);
        applicant.setStatus(false);
        applicant.setFirstName(signupDto.firstName());
        applicant.setLastName(signupDto.lastName());
        applicant.setEmail(signupDto.email());
        applicant.setPassword(passwordEncoder.encode(signupDto.password()));
        applicant.setVerificationCode("000");
        applicant.setCodeExpiration(LocalDate.now());
        applicant.setCreatedAt(LocalDate.now());
        applicant.setUpdatedAt(LocalDate.now());
        return applicant;
    }
}
