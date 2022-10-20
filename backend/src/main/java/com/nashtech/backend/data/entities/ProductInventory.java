package com.nashtech.backend.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "product_inventory")
public class ProductInventory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @OneToOne(mappedBy = "productInventory")
    private Product product;

}
