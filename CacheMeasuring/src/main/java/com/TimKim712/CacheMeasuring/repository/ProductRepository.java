package com.TimKim712.CacheMeasuring.repository;

import com.TimKim712.CacheMeasuring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}