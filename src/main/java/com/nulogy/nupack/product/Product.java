package com.nulogy.nupack.product;

public class Product {

    private double price;
    private ProductType productType;
    private int numOfPeople;
    
    public Product() {
        
    }
    
    public Product(double price, ProductType productType, int numOfPeople) {
        this.price = price;
        this.productType = productType;
        this.numOfPeople = numOfPeople;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
