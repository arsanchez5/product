package com.banquito.core.products.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.banquito.core.products.model.Product;
import com.banquito.core.products.model.ProductPK;
import com.banquito.core.products.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public Product findById(ProductPK pk) {
        Optional<Product> productOpt = this.productRepository.findById(pk);
        if (productOpt.isPresent()) {
            return productOpt.get();
        } else {
            throw new RuntimeException("No existe el producto con id: " + pk);
        }
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
