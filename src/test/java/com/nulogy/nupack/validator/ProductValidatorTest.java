package com.nulogy.nupack.validator;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.nulogy.nupack.exception.ProductValidationException;
import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;

public class ProductValidatorTest {

    private ProductValidator validator;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        this.validator = new ProductValidator();
    }

    @Test
    public void testValidateProductPriceNegative() throws ProductValidationException  {
        Product product = new Product(new BigDecimal(-1), ProductType.OTHER, 0);

        exception.expect(ProductValidationException.class);
        exception.expectMessage("Invalid Product.price value: -1");
        
        this.validator.validate(product);    
    }

    @Test
    public void testValidateProductPeopleNegative() throws ProductValidationException {
        Product product = new Product(new BigDecimal(1), ProductType.OTHER, -4);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Invalid Product.numOfPeople value: -4");
        
        this.validator.validate(product);    
    }

    @Test
    public void testValidateProductPriceNull() throws ProductValidationException {
        Product product = new Product(null, ProductType.OTHER, 0);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Invalid Product.price value: null");
        
        this.validator.validate(product);    
    }

    @Test
    public void testValidateProductTypeNull() throws ProductValidationException {
        Product product = new Product(new BigDecimal(1), null, 0);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Invalid Product.productType value: null");
        
        this.validator.validate(product);    
    }

    @Test
    public void testValidProduct() throws ProductValidationException {
        Product product = new Product(new BigDecimal(1), ProductType.OTHER, 0);
        assertTrue(this.validator.validate(product));
    }

}
