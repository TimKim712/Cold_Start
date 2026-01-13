package com.TimKim712.CacheMeasuring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.TimKim712.CacheMeasuring.service.ProductService;
import com.TimKim712.CacheMeasuring.model.Product;
import com.TimKim712.CacheMeasuring.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    
    @Autowired
    private ProductRepository productRepository;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }
    
    
}