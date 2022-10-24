package com.nashtech.backend.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_category")
public class ProductCategory extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String categoryName;

    @Column
    private String categoryDesc;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;

}
