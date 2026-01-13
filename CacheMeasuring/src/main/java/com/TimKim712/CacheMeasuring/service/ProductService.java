package com.TimKim712.CacheMeasuring.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.TimKim712.CacheMeasuring.model.Product;
import com.TimKim712.CacheMeasuring.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "products", key = "#id")
    public Product getProduct(Long id) {
        simulateSlowQuery();
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Cacheable(value = "products", key = "'all'")
    public List<Product> getAllProducts() {
        simulateSlowQuery();
        return repository.findAll();
    }

    @Transactional
    @CacheEvict(value = "products", allEntries = true)
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    private void simulateSlowQuery() {
        try {
            Thread.sleep(200); 
        } catch (InterruptedException ignored) {}
    }
}
