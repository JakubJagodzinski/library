package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Genre")
@Table(name = "genres")
@NoArgsConstructor
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    private String name;

    @ManyToMany(mappedBy = "genres")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }
}
