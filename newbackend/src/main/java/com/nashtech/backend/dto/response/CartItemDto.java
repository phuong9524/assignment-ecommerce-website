package com.nashtech.backend.dto.response;

import com.nashtech.backend.data.entities.Cart;
import com.nashtech.backend.data.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CartItemDto {
    private Integer id;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productName" + product.getName() +
                '}';
    }
}
