package com.nulogy.nupack.markup;

import java.math.BigDecimal;

import com.nulogy.nupack.product.ProductType;

public abstract class Markup {

    protected double markupPercent;
    protected ProductType productType;
    
    public Markup() {
        
    }
    
    public BigDecimal calculateMarkup(BigDecimal productPrice) {
        return productPrice.multiply(new BigDecimal(markupPercent));
    }
    

    public double getMarkupPercent() {
        return markupPercent;
    }

    public ProductType getProductType() {
        return productType;
    }    
}
