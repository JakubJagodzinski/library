package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Keyword")
@Table(name = "keywords")
@NoArgsConstructor
@Data
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long keywordId;

    private String name;

    @ManyToMany(mappedBy = "keywords")
    @ToString.Exclude
    private final List<Book> books = new ArrayList<>();

    public Keyword(String name) {
        this.name = name;
    }
}
