package com.ghulam.loan.loanservice.controller;

import com.ghulam.loan.loanservice.dto.PaginationDto;
import com.ghulam.loan.loanservice.http.POST;
import com.ghulam.loan.loanservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST(path = "/product-list")
    public ResponseEntity<?> getProductList(@RequestBody PaginationDto paginationDto) {
        return null;
    }

    @POST(path = "/save-product")
    public ResponseEntity<?> saveProduct(@RequestParam Integer id) {
        return null;
    }

    @POST(path = "/by-category")
    public ResponseEntity<?> productByCategory(@RequestParam(name = "category-id") String category) {
        return null;
    }

    @POST(path = "/by-name")
    public ResponseEntity<?> productByName(@RequestParam(name = "name-id") String category) {
        return null;
    }
}
