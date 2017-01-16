package com.nulogy.nupack.markup;

import java.math.BigDecimal;

public class PersonMarkup extends Markup {

    private int numOfPeople;
    
    public PersonMarkup(int numOfPeople) {
        this.markupPercent = 0.012;
        this.numOfPeople = numOfPeople;
    }
    
    @Override
    public BigDecimal calculateMarkup(BigDecimal productPrice) {
        double totalMarkupPercent = markupPercent*numOfPeople;
        return productPrice.multiply(new BigDecimal(totalMarkupPercent));
    }

}
