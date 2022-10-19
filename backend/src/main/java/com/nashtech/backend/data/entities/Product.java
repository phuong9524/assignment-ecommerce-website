package com.nashtech.backend.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String desc;

    private String SKU;

    @ManyToOne()
    private ProductCategory productCategory;

    @OneToOne()
    private ProductInventory productInventory;

    private Double price;

    @ManyToOne()
    private Discount discount;
}
