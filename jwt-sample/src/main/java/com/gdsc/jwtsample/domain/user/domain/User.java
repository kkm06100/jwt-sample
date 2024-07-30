package com.gdsc.jwtsample.domain.user.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tbl_user")
@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String accountId, String password, String email) {
        this.accountId = accountId;
        this.password = password;
        this.email = email;
    }

    @Column(columnDefinition = "VARCHAR(50)")
    private String accountId;
    @Column(columnDefinition = "VARCHAR(50)")
    private String password;
    @Column(columnDefinition = "VARCHAR(100)")
    private String email;
}
