package com.tamph.ecommerce.product;

import java.math.BigDecimal;

public record ProductPurchaseRespone(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
        ) {
}
