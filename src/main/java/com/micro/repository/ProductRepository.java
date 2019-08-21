package com.micro.repository;

import com.micro.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ismael Sadeghi, 8/19/2019 8:52 AM
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
}