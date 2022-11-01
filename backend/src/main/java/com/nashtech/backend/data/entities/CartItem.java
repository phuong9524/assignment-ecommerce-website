package com.nashtech.backend.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer itemQuantity;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Transient
    public Double getTotalPrice() {
        return product.getPrice() * getItemQuantity();
    }



}
