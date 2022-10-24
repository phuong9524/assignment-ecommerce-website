package com.nashtech.backend.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "rating")

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double rate;

    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Rating (
            Integer id,
            Double rate,
            String comment,
            User user,
            Product product) {
        this.id = id;
        this.rate = rate;
        this.comment = comment;
        this.user = user;
        this.product = product;
    }
}
