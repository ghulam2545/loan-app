package com.ghulam.loan.authservice.model;

import com.ghulam.loan.authservice.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "applicants")
@Getter
@Setter
public class Applicant extends BaseEntity implements Serializable, UserDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String verificationCode;
    private LocalDate codeExpiration;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(UserRole.APPLICANT.toString()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
