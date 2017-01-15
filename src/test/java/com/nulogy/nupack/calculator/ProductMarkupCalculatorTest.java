package com.nulogy.nupack.calculator;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.nulogy.nupack.product.Product;
import com.nulogy.nupack.product.ProductType;

public class ProductMarkupCalculatorTest {

   private ProductMarkupCalculator calc;
    
   @Before
   public void setup() {
       this.calc = new ProductMarkupCalculator();
   }
   
   public void tearDown() {
       
   }
   
   @Test
   public void testCalculateFlatMarkupOnly() {
       Product product = new Product(new BigDecimal(1.00), ProductType.OTHER, 0);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1.05)));
   }
   
   @Test
   public void testCalculateProductTypeFoodOnly() {
       Product product = new Product(new BigDecimal(1.00), ProductType.FOOD, 0);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1.1865)));
   }
   
   @Test
   public void testCalculateProductTypeElectronicsOnly() {
       Product product = new Product(new BigDecimal(1.00), ProductType.ELECTRONICS, 0);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1.071)));
   }
   
   @Test
   public void testCalculatePeopleMarkupOnly() {
       Product product = new Product(new BigDecimal(1.00), ProductType.OTHER, 1);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1.0626)));
   }
   
   @Test
   public void testCalculateProductTypePharmaceuticalsOnly() {
       Product product = new Product(new BigDecimal(1.00), ProductType.PHARMACEUTICALS, 0);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1.12875)));
   }
   
   @Test
   public void testCalculateExample1() {
       Product product = new Product(new BigDecimal(1299.99), ProductType.FOOD, 3);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(1591.58)));
   }
   
   @Test
   public void testCalculateExample2() {
       Product product = new Product(new BigDecimal(5432.00), ProductType.PHARMACEUTICALS, 1);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(6199.81)));
   }
   
   @Test
   public void testCalculateExample3() {
       Product product = new Product(new BigDecimal(12456.95), ProductType.OTHER, 4);
       BigDecimal finalCost = this.calc.calculate(product);
       assertTrue(finalCost.equals(new BigDecimal(13707.63)));
   }
   
}
