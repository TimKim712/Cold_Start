package com.TimKim712.CacheMeasuring.service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.TimKim712.CacheMeasuring.repository.ProductRepository;
import com.TimKim712.CacheMeasuring.model.Product;
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // @Cacheable(value = "products", key = "#id")
    public Product getProduct(Long id) {
        simulateSlowQuery();
        return repository.findById(id).orElseThrow();
    }

    private void simulateSlowQuery() {
        try {
            Thread.sleep(200); // simulate DB latency
        } catch (InterruptedException ignored) {}
    }
}