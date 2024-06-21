package com.banquito.core.products.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.products.model.Product;
import com.banquito.core.products.model.ProductPK;
import com.banquito.core.products.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{codeProductType}/{code}")
    public ResponseEntity<Product> getById(@PathVariable String codeProductType, @PathVariable String code) {
        ProductPK pk = new ProductPK(codeProductType, code);
        try {
            return ResponseEntity.ok(this.productService.findById(pk));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getByName(@RequestParam("name") String name) {
        try {
            List<Product> products = this.productService.findByName(name);
            return ResponseEntity.ok(products);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
