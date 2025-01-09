package com.tamph.ecommerce.customer;

public record CustomerRespone(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address

) {
}
