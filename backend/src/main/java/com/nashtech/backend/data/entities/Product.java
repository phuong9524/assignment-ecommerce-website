package com.nashtech.backend.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String desc;

    private Double price;

    private String image;

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToOne()
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private ProductInventory productInventory;

    @ManyToOne()
    @JoinColumn(name = "discount", referencedColumnName = "id")
    private Discount discount;

    public Product(Integer id,
                   String name,
                   String desc,
                   Double price,
                   String image,
                   ProductCategory productCategory,
                   ProductInventory productInventory,
                   Discount discount) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.image = image;
        this.productCategory = productCategory;
        this.productInventory = productInventory;
        this.discount = discount;
    }
}
