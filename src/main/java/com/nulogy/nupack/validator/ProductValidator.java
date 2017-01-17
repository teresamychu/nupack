package com.nulogy.nupack.validator;

import java.math.BigDecimal;

import com.nulogy.nupack.exception.ProductValidationException;
import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;

public class ProductValidator {
    
    public ProductValidator() {
    }
    
    public boolean validate(Product product) throws ProductValidationException {
     return validateProductPrice(product.getPrice())
            && validateProductNumOfPeople(product.getNumOfPeople())
            && validateProductType(product.getProductType());
             
    }
    
    private boolean validateProductPrice(BigDecimal productPrice) throws ProductValidationException {
        if (productPrice == null || productPrice.compareTo(new BigDecimal(0) ) == -1) {
            throw new ProductValidationException("Invalid Product.price value: " + productPrice);
        } 
        return true;
    }
    
    private boolean validateProductNumOfPeople(int numOfPeople) throws ProductValidationException {
        if ( numOfPeople < 0) {
           throw new ProductValidationException("Invalid Product.numOfPeople value: " + numOfPeople);
        }
        return true;
    }
    
    private boolean validateProductType(ProductType type) throws ProductValidationException {
        if (type == null) {
            throw new ProductValidationException("Invalid Product.productType value: " + type);
        }
        return true;
    }
    
}
