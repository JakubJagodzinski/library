package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Series")
@Table(name = "series")
@NoArgsConstructor
@Data
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Long seriesId;

    private String name;

    @OneToMany(mappedBy = "series")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public Series(String name) {
        this.name = name;
    }
}
