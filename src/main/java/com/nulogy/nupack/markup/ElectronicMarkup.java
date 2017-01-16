package com.nulogy.nupack.markup;

import com.nulogy.nupack.product.ProductType;

public class ElectronicMarkup extends Markup {

    public ElectronicMarkup() {
        this.productType = ProductType.ELECTRONICS;
        this.markupPercent = 0.02;
    }
}
