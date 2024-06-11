package com.banquito.core.products.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ProductPK implements Serializable {

    @Column(name = "CODE_PRODUCT_TYPE", length = 20, nullable = false)
    private String codeProductType;
    @Column(name = "CODE_PRODUCT", length = 30, nullable = false)
    private String code;

    public ProductPK(String codeProductType, String code) {
        this.codeProductType = codeProductType;
        this.code = code;
    }

    

}
