package com.gdsc.jwtsample.domain.user.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    public User(String accountId, String password, String deviceToken, String email) {
        this.accountId = accountId;
        this.password = password;
        this.deviceToken = deviceToken;
        this.email = email;
    }


    @Column(columnDefinition = "VARCHAR(50)")
    private String accountId;
    @Column(columnDefinition = "VARCHAR(50)")
    private String password;



    @Setter
    @Column(name = "app_device_token")
    private String deviceToken;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;


}
