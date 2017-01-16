package com.nulogy.nupack.markup;

import com.nulogy.nupack.product.ProductType;

public class PharmaceuticalMarkup extends Markup {

    
    public PharmaceuticalMarkup() {
        this.productType = ProductType.PHARMACEUTICALS;
        this.markupPercent = 0.075;
    }
}
