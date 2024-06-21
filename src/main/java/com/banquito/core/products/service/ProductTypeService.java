package com.banquito.core.products.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.banquito.core.products.model.ProductType;
import com.banquito.core.products.repository.ProductTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public ProductType findById(String codeProductType) {
        Optional<ProductType> productTypeOpt = this.productTypeRepository.findById(codeProductType);
        if (productTypeOpt.isPresent()) {
            return productTypeOpt.get();
        } else {
            throw new RuntimeException("No existe el tipo de producto con código: " + codeProductType);
        }
    }

    public List<ProductType> findByName(String name) {
        return productTypeRepository.findByName(name);
    }

}
