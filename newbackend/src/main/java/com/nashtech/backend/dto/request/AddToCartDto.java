package com.nashtech.backend.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ",";
    }
}
