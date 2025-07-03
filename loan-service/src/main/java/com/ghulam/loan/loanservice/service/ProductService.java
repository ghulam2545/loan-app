package com.ghulam.loan.loanservice.service;

import com.ghulam.loan.loanservice.enums.ProductCategory;
import com.ghulam.loan.loanservice.model.Product;
import com.ghulam.loan.loanservice.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        try {
            return productRepo.findAll();
        } catch (Exception e) {
            log.debug("Error while getting all products", e);
        }
        return List.of();
    }

    public boolean saveProduct(Product product) {
        Product p = new Product();

        try {
            productRepo.save(p);
            return true;
        } catch (Exception e) {
            log.debug("Error while saving product", e);
        }
        return false;
    }

    public List<Product> getProductsByCategory(ProductCategory categoryId) {
        try {
            return productRepo.findByCategory(categoryId);
        } catch (Exception e) {
            log.debug("Error while getting all products by category", e);
        }
        return List.of();
    }

    public List<Product> getProductsByName(String name) {
        try {
            return productRepo.findByNameContainingIgnoreCase(name);
        } catch (Exception e) {
            log.debug("Error while getting all products by name", e);
        }
        return List.of();
    }
}
