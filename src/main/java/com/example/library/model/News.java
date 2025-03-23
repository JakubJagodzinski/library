package com.example.library.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "News")
@Table(name = "news")
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

    public News() {
    }

    public News(String image, LocalDate newsDate, String text, String title, Book book) {
        this.image = image;
        this.newsDate = newsDate;
        this.text = text;
        this.title = title;
        this.book = book;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", image='" + image + '\'' +
                ", newsDate=" + newsDate +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", book=" + book +
                '}';
    }
}
