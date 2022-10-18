package com.nashtech.backend.data.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Builder
@ToString
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer telephone;
    private String role;
    private Timestamp createAt;
    private Timestamp modifiedAt;

}
