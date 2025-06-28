package com.ghulam.loan.authservice.dto;

public record SignupDto(

        String firstName,
        String lastName,
        String email,
        String password
) {
}

