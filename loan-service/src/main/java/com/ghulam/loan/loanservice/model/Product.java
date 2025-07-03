package com.ghulam.loan.loanservice.model;

import com.ghulam.loan.loanservice.enums.ProductCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;
    private Double interestRate;
    private Integer maxLoanAmount;
    private boolean active;
}
