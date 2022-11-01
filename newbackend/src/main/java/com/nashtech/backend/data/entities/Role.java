package com.nashtech.backend.data.entities;

import com.nashtech.backend.constant.AccountRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AccountRole name;

    public Role(AccountRole name) {
        this.name = name;
    }
}

