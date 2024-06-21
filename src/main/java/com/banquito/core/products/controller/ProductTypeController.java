package com.banquito.core.products.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.products.model.ProductType;
import com.banquito.core.products.service.ProductTypeService;

@RestController
@RequestMapping(path = "/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/{codeProductType}")
    public ResponseEntity<ProductType> getById(@PathVariable String codeProductType) {
        try {
            return ResponseEntity.ok(this.productTypeService.findById(codeProductType));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductType>> getByName(@RequestParam("name") String name) {
        try {
            List<ProductType> productTypes = this.productTypeService.findByName(name);
            return ResponseEntity.ok(productTypes);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
