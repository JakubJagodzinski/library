package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publisher")
@Table(name = "publishers")
@NoArgsConstructor
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    private String name;

    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }
}
