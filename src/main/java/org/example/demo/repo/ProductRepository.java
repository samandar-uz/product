package org.example.demo.repo;

import org.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    void removeProductById(Integer id);
}
