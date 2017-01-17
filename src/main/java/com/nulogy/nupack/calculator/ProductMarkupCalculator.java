package com.nulogy.nupack.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;

import com.nulogy.nupack.exception.ProductValidationException;
import com.nulogy.nupack.markup.ElectronicMarkup;
import com.nulogy.nupack.markup.FlatMarkup;
import com.nulogy.nupack.markup.FoodMarkup;
import com.nulogy.nupack.markup.Markup;
import com.nulogy.nupack.markup.PersonMarkup;
import com.nulogy.nupack.markup.PharmaceuticalMarkup;
import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;
import com.nulogy.nupack.validator.ProductValidator;

public class ProductMarkupCalculator {
    
    private HashMap<ProductType, Markup> markupStore;
    private ProductValidator validator;
    
    public ProductMarkupCalculator() {
        this.markupStore = new HashMap<ProductType, Markup>();
        this.markupStore.put(ProductType.FOOD, new FoodMarkup());
        this.markupStore.put(ProductType.ELECTRONICS, new ElectronicMarkup());
        this.markupStore.put(ProductType.PHARMACEUTICALS, new PharmaceuticalMarkup());
        this.validator = new ProductValidator();
    }

    public String calculate(Product product) throws ProductValidationException {
        BigDecimal finalCost = new BigDecimal(0);
        
        //Would probably also validate on input before Product object is created.
        
        //This validation call is here assuming the above and that the product object 
        //does NOT go directly from creation to calculation, therefore raising a risk that
        //the product fields have changed.
        if (this.validator.validate(product)) {
            BigDecimal flatMarkupValue = calculateFlatMarkup(product.getPrice());
            BigDecimal productTypeMarkup = calculateProductTypeMarkup(flatMarkupValue, product.getProductType());
            BigDecimal peopleMarkup = calculatePeopleMarkup(flatMarkupValue, product.getNumOfPeople());
            
            finalCost =  flatMarkupValue.add(productTypeMarkup).add(peopleMarkup);
        }
        
        return NumberFormat.getCurrencyInstance().format(finalCost);
        
        
    }
    
    private BigDecimal calculateProductTypeMarkup(BigDecimal flatMarkupValue, ProductType productType) {
       BigDecimal productTypeMarkup = new BigDecimal(0);
       if (productType != ProductType.OTHER) {
           productTypeMarkup = this.markupStore.get(productType).calculateMarkup(flatMarkupValue);
       }
       return productTypeMarkup;
    }
    
    private BigDecimal calculatePeopleMarkup(BigDecimal flatMarkupValue, int numOfPeople) {
        BigDecimal peopleMarkup = new BigDecimal(0);
        peopleMarkup = new PersonMarkup(numOfPeople).calculateMarkup(flatMarkupValue);
        return peopleMarkup;
    }
    
    private BigDecimal calculateFlatMarkup(BigDecimal productPrice) {
        BigDecimal flatMarkup = new FlatMarkup().calculateMarkup(productPrice);
        return flatMarkup;
    }
    
    
    
}
