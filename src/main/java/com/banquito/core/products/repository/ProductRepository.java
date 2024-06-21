package com.banquito.core.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.products.model.Product;
import com.banquito.core.products.model.ProductPK;

public interface ProductRepository extends JpaRepository<Product, ProductPK> {

    List<Product> findByName(String name);
}
