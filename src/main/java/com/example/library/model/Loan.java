package com.example.library.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Loan")
@Table(name = "loans")
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
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Book book;

    public Loan() {
    }

    public Loan(LocalDate borrowDate, Boolean borrowed, Integer fee, LocalDate returnDate, UserData userData, Book book) {
        this.borrowDate = borrowDate;
        this.borrowed = borrowed;
        this.fee = fee;
        this.returnDate = returnDate;
        this.userData = userData;
        this.book = book;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long bookUserId) {
        this.loanId = bookUserId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", borrowDate=" + borrowDate +
                ", borrowed=" + borrowed +
                ", fee=" + fee +
                ", returnDate=" + returnDate +
                ", userData=" + userData.getUserDataId() +
                ", book=" + book +
                '}';
    }
}
