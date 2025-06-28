package com.ghulam.loan.authservice.repo;

import com.ghulam.loan.authservice.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, String> {

    Optional<Applicant> findByEmail(String email);
}
