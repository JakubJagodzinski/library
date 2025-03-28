package com.example.library.book;

import com.example.library.author.Author;
import com.example.library.genre.Genre;
import com.example.library.keyword.Keyword;
import com.example.library.loan.Loan;
import com.example.library.news.News;
import com.example.library.publisher.Publisher;
import com.example.library.series.Series;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Book")
@Table(name = "books")
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    private String isbn;

    private String image;

    private String name;

    private String place;

    private Integer quantity;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer tome;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @ManyToMany
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @ToString.Exclude
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_keywords",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    @ToString.Exclude
    private List<Keyword> keywords = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private List<News> news = new ArrayList<>();

    public Book(String isbn, String image, String name, String place, Integer quantity, LocalDate releaseDate, Integer tome, Publisher publisher, Series series, List<Genre> genres, List<Author> authors, List<Keyword> keywords) {
        this.isbn = isbn;
        this.image = image;
        this.name = name;
        this.place = place;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.tome = tome;
        this.publisher = publisher;
        this.series = series;
        this.genres = genres;
        this.authors = authors;
        this.keywords = keywords;
        this.loans = null;
        this.news = null;
    }
}
