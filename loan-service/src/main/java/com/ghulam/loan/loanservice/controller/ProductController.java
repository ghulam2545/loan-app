package com.ghulam.loan.loanservice.controller;

import com.ghulam.loan.loanservice.dto.PaginationDto;
import com.ghulam.loan.loanservice.enums.ProductCategory;
import com.ghulam.loan.loanservice.utils.http.POST;
import com.ghulam.loan.loanservice.model.Product;
import com.ghulam.loan.loanservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // TODO: apply pagination for result data
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST(path = "/product-list")
    public ResponseEntity<?> getProductList(@RequestBody PaginationDto paginationDto) {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @POST(path = "/save-product")
    public ResponseEntity<?> saveProduct(@RequestParam Integer id) {
        boolean saved = productService.saveProduct(null);
        return ResponseEntity.ok(saved);
    }

    @POST(path = "/by-category")
    public ResponseEntity<?> productByCategory(@RequestParam(name = "category-id") ProductCategory category) {
        List<Product> byCategory = productService.getProductsByCategory(category);
        return ResponseEntity.ok(byCategory);
    }

    @POST(path = "/by-name")
    public ResponseEntity<?> productByName(@RequestParam(name = "name-id") String name) {
        List<Product> byName = productService.getProductsByName(name);
        return ResponseEntity.ok(byName);
    }
}
