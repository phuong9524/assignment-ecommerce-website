package com.nashtech.backend.dto.response;
import lombok.*;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CartDto {
    private List<CartItemDto> cartItems;
    private double totalCost;

}
