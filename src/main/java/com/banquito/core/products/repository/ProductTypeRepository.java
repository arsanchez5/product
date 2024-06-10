package com.banquito.core.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.products.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, String> {

    List<ProductType> findByName(String name);
}
