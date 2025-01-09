package com.tamph.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private final String msg;

    public BusinessException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
