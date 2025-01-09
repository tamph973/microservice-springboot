package com.tamph.ecommerce.payment;

import com.tamph.ecommerce.customer.CustomerResponse;
import com.tamph.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
