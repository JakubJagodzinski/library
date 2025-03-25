package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Account")
@Table(name = "accounts")
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    private Boolean enabled;

    private String login;

    private String password;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data_id", unique = true)
    private UserData userData;

    public Account(Boolean enabled, String login, String password, String role, UserData userData) {
        this.enabled = enabled;
        this.login = login;
        this.password = password;
        this.role = role;
        this.userData = userData;
    }
}
