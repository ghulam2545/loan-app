package com.ghulam.loan.authservice.security;

import com.ghulam.loan.authservice.model.Applicant;
import com.ghulam.loan.authservice.repo.ApplicantRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ApplicantRepo applicantRepo;

    public CustomUserDetailsService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Applicant applicant = applicantRepo.findByEmail(username).orElse(null);
        if (applicant != null) {
            return applicant;
        }
        throw new UsernameNotFoundException("Applicant not found with email: " + username);
    }
}
