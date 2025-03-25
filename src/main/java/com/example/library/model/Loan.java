package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity(name = "Loan")
@Table(name = "loans")
@NoArgsConstructor
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_user_id")
    private Long loanId;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    private Boolean borrowed;

    private Integer fee;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "user_data_id", referencedColumnName = "user_data_id", nullable = false)
    @ToString.Exclude
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    @ToString.Exclude
    private Book book;

    public Loan(LocalDate borrowDate, Boolean borrowed, Integer fee, LocalDate returnDate, UserData userData, Book book) {
        this.borrowDate = borrowDate;
        this.borrowed = borrowed;
        this.fee = fee;
        this.returnDate = returnDate;
        this.userData = userData;
        this.book = book;
    }
}
