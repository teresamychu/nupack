package com.nulogy.nupack.product;

import java.math.BigDecimal;

public class Product {

    private BigDecimal price;
    private ProductType productType;
    private int numOfPeople;
    
    //Given that I did not handle the input,
    //I have assumed that the price would have been sanitized
    //and converted to BigDecimal.
    public Product(BigDecimal price, ProductType productType, int numOfPeople) {
        this.price = price;
        this.productType = productType;
        this.numOfPeople = numOfPeople;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }
    
    
}
