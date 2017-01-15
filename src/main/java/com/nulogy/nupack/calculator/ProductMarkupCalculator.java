package com.nulogy.nupack.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;

import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;

public class ProductMarkupCalculator {
    
    public ProductMarkupCalculator() {
        
    }

    public String calculate(Product product) {
        BigDecimal flatMarkupValue = product.getPrice().multiply(new BigDecimal(1.05));
        BigDecimal productTypeMarkup = calculateProductTypeMarkup(flatMarkupValue, product.getProductType());
        BigDecimal peopleMarkup = calculatePeopleMarkup(flatMarkupValue, product.getNumOfPeople());
        BigDecimal finalCost =  flatMarkupValue.add(productTypeMarkup).add(peopleMarkup);
        return NumberFormat.getCurrencyInstance().format(finalCost);
        
    }
    
    private BigDecimal calculateProductTypeMarkup(BigDecimal flatMarkupValue, ProductType productType) {
        BigDecimal productTypeMarkup = new BigDecimal(0);
        switch (productType) {
            case PHARMACEUTICALS:
                productTypeMarkup = flatMarkupValue.multiply(new BigDecimal(0.075));
                break;
            case ELECTRONICS:
                productTypeMarkup = flatMarkupValue.multiply(new BigDecimal(0.02));
                break;
            case FOOD:    
                productTypeMarkup = flatMarkupValue.multiply(new BigDecimal(0.13));
                break;
            default:
                break;
        }
        return productTypeMarkup;
    }
    
    private BigDecimal calculatePeopleMarkup(BigDecimal flatMarkupValue, int numOfPeople) {
        double markupPercent = numOfPeople*0.012;
        return flatMarkupValue.multiply(new BigDecimal(markupPercent));
    }
    
    
    
}
