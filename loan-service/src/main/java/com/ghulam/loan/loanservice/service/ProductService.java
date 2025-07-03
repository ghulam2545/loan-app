package com.ghulam.loan.loanservice.service;

import com.ghulam.loan.loanservice.repo.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo  productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
