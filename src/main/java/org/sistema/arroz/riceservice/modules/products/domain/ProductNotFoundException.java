package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.PROD_01_MESSAGE;

@Getter
public class ProductNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "PROD_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long productId;
    }

    public ProductNotFoundException(Long productId){
        super();
        this.message = String.format(PROD_01_MESSAGE, productId);
        this.data = productId;
    }
}
