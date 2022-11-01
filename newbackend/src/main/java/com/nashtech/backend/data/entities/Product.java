package com.nashtech.backend.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    private String description;

    private Double price;

    private String image;

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToMany()
    private List<Rating> rating = new ArrayList<>();

}

