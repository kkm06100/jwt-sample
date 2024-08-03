package com.gdsc.jwtsample.domain.user.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Table(name = "tbl_user")
@NoArgsConstructor
@Getter
@Entity
@Cacheable
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder
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
