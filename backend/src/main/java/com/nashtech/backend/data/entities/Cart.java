package com.nashtech.backend.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cart")
public class Cart extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double total;

    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany
    private List<CartItem> cartItem = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        List<CartItem> cartItems = getCartItem();
        for (CartItem cartItem1: cartItems) {
            total += cartItem1.getTotalPrice();
        }
        return total;
    }

}
