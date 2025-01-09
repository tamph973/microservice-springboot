package com.tamph.ecommerce.kafka;

import com.tamph.ecommerce.customer.CustomerResponse;
import com.tamph.ecommerce.order.PaymentMethod;
import com.tamph.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
