package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Author")
@Table(name = "authors")
@NoArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    private String name;

    @ManyToMany(mappedBy = "authors")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }
}
