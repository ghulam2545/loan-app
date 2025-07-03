package com.ghulam.loan.loanservice.repo;

import com.ghulam.loan.loanservice.enums.ProductCategory;
import com.ghulam.loan.loanservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByNameContainingIgnoreCase(String name);
}
