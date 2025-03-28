package com.example.library.news;

import com.example.library.book.Book;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "News")
@Table(name = "news")
@NoArgsConstructor
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long newsId;

    private String image;

    @Column(name = "news_date")
    private LocalDate newsDate;

    private String text;

    private String title;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public News(String image, LocalDate newsDate, String text, String title, Book book) {
        this.image = image;
        this.newsDate = newsDate;
        this.text = text;
        this.title = title;
        this.book = book;
    }
}
