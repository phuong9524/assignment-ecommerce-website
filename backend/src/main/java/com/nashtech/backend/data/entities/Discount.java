package com.nashtech.backend.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "discount")
public class Discount extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String discountName;

    @Column (name = "desc")
    private String discountDesc;

    private Boolean active;

    @OneToMany(mappedBy = "discount")
    private Set<Product> products;
}
