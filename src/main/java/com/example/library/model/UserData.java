package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "UserData")
@Table(name = "user_data")
@NoArgsConstructor
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_data_id")
    private Long userDataId;

    @Column(name = "ic_number")
    private String icNumber;

    private String pesel;

    private String city;

    private String email;

    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "postal_code")
    private String postalCode;

    private String street;

    private String surname;

    @OneToOne(mappedBy = "userData")
    @ToString.Exclude
    private Account account;

    @OneToMany(mappedBy = "userData")
    @ToString.Exclude
    private List<Loan> loans = new ArrayList<>();

    public UserData(String icNumber, String pesel, String city, String email, String name, String phoneNumber, String postalCode, String street, String surname) {
        this.icNumber = icNumber;
        this.pesel = pesel;
        this.city = city;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.street = street;
        this.surname = surname;
    }
}
