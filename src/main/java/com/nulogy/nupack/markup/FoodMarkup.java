package com.nulogy.nupack.markup;

import com.nulogy.nupack.product.ProductType;

public class FoodMarkup extends Markup {

    public FoodMarkup() {
        this.productType = ProductType.FOOD;
        this.markupPercent = 0.13;
    }

}
