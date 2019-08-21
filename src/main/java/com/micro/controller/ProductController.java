package com.micro.controller;

import com.micro.domain.Product;
import com.micro.exception.ProductNotFoundException;
import com.micro.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @author Ismael Sadeghi, 8/19/2019 8:56 AM
 */
@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }
    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
    }
}