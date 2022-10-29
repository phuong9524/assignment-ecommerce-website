package com.nashtech.backend.data.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
