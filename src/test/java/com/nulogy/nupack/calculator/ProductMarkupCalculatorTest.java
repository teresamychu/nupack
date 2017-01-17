package com.nulogy.nupack.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.nulogy.nupack.exception.ProductValidationException;
import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;

public class ProductMarkupCalculatorTest {

   private ProductMarkupCalculator calc;
    
   @Before
   public void setup() {
       this.calc = new ProductMarkupCalculator();
   }
   
   @Test
   public void testCalculateFlatMarkupOnly() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1.00), ProductType.OTHER, 0);
       assertEquals(this.calc.calculate(product), "$1.05");
   }
   
   @Test
   public void testCalculateProductTypeFoodOnly() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1.00), ProductType.FOOD, 0);
       assertEquals(this.calc.calculate(product), "$1.19");
   }
   
   @Test
   public void testCalculateProductTypeElectronicsOnly() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1.00), ProductType.ELECTRONICS, 0);
       assertEquals(this.calc.calculate(product), "$1.07");
   }
   
   @Test
   public void testCalculatePeopleMarkupOnly() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1.00), ProductType.OTHER, 1);
       assertEquals(this.calc.calculate(product), "$1.06");
   }
   
   @Test
   public void testCalculateProductTypePharmaceuticalsOnly() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1.00), ProductType.PHARMACEUTICALS, 0);
       assertEquals(this.calc.calculate(product), "$1.13");
   }
   
   @Test
   public void testCalculateExample1() throws ProductValidationException {
       Product product = new Product(new BigDecimal(1299.99), ProductType.FOOD, 3);
       assertEquals(this.calc.calculate(product), "$1,591.58");
   }
   
   @Test
   public void testCalculateExample2() throws ProductValidationException {
       Product product = new Product(new BigDecimal(5432.00), ProductType.PHARMACEUTICALS, 1);      
       assertEquals(this.calc.calculate(product), "$6,199.81");
   }
   
   @Test
   public void testCalculateExample3() throws ProductValidationException {
       Product product = new Product(new BigDecimal(12456.95), ProductType.OTHER, 4);
       assertEquals(this.calc.calculate(product), "$13,707.63");
   }
   
}
