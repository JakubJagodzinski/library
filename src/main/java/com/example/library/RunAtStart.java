package com.example.library;

import com.example.library.model.*;
import com.example.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RunAtStart {

    private final AccountRepository accountRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final KeywordRepository keywordRepository;
    private final LoanRepository loanRepository;
    private final NewsRepository newsRepository;
    private final PublisherRepository publisherRepository;
    private final SeriesRepository seriesRepository;
    private final UserDataRepository userDataRepository;


    @Autowired
    public RunAtStart(AccountRepository accountRepository, AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository, KeywordRepository keywordRepository, LoanRepository loanRepository, NewsRepository newsRepository, PublisherRepository publisherRepository, SeriesRepository seriesRepository, UserDataRepository userDataRepository) {
        super();
        this.accountRepository = accountRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.keywordRepository = keywordRepository;
        this.loanRepository = loanRepository;
        this.newsRepository = newsRepository;
        this.publisherRepository = publisherRepository;
        this.seriesRepository = seriesRepository;
        this.userDataRepository = userDataRepository;
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            // Genres
            Genre genre1 = new Genre("Fiction");
            Genre genre2 = new Genre("Fantasy");
            Genre genre3 = new Genre("Thriller");
            genreRepository.saveAll(List.of(genre1, genre2, genre3));

            // Authors
            Author author1 = new Author("John Smith");
            Author author2 = new Author("Emily Johnson");
            Author author3 = new Author("Michael Brown");
            authorRepository.saveAll(List.of(author1, author2, author3));

            // Publishers
            Publisher publisher1 = new Publisher("HarperCollins");
            Publisher publisher2 = new Publisher("Penguin Random House");
            Publisher publisher3 = new Publisher("Macmillan");
            publisherRepository.saveAll(List.of(publisher1, publisher2, publisher3));

            // Series
            Series series1 = new Series("The Adventure Series");
            Series series2 = new Series("Fantasy World");
            Series series3 = new Series("Mystery Chronicles");
            seriesRepository.saveAll(List.of(series1, series2, series3));

            // Keywords
            Keyword keyword1 = new Keyword("Adventure");
            Keyword keyword2 = new Keyword("Magic");
            Keyword keyword3 = new Keyword("Detective");
            keywordRepository.saveAll(List.of(keyword1, keyword2, keyword3));

            // UserData
            UserData userData1 = new UserData("01234", "01234567891", "Los Angeles", "alice@example.com", "Alice", "123456789", "01-234", "123 Elm St", "Walker");
            UserData userData2 = new UserData("12345", "12345678912", "New York", "bob@example.com", "Bob", "234567890", "12-345", "456 Oak St", "Williams");
            UserData userData3 = new UserData("23456", "23456789123", "Chicago", "charlie@example.com", "Charlie", "345678901", "23-456", "789 Pine St", "Davis");

            // Account Data
            Account account1 = new Account(true, "alice123", "password123", "USER", userData1);
            Account account2 = new Account(true, "bob456", "password456", "USER", userData2);
            Account account3 = new Account(true, "charlie789", "password789", "USER", userData3);
            accountRepository.saveAll(List.of(account1, account2, account3));

            // Books
            Book book1 = new Book("978-1234567890", "book1.jpg", "The Lost World", "London", 12, LocalDate.of(2020, 5, 15), 320, publisher1, series1, List.of(genre1), List.of(author1), List.of(keyword1), null, null);
            Book book2 = new Book("978-2345678901", "book2.jpg", "Magic in the Forest", "Paris", 18, LocalDate.of(2018, 7, 1), 450, publisher2, series2, List.of(genre2), List.of(author2), List.of(keyword2), null, null);
            Book book3 = new Book("978-3456789012", "book3.jpg", "The Detective's Secret", "Berlin", 10, LocalDate.of(2019, 9, 10), 250, publisher3, series3, List.of(genre3), List.of(author3), List.of(keyword3), null, null);
            bookRepository.saveAll(List.of(book1, book2, book3));

            // Loans
            Loan loan1 = new Loan(LocalDate.now(), true, 1, LocalDate.now().plusDays(14), userData1, book1);
            Loan loan2 = new Loan(LocalDate.now(), true, 2, LocalDate.now().plusDays(14), userData2, book2);
            Loan loan3 = new Loan(LocalDate.now(), true, 3, LocalDate.now().plusDays(14), userData3, book3);
            loanRepository.saveAll(List.of(loan1, loan2, loan3));

            // News
            News news1 = new News("news1.jpg", LocalDate.now(), "Exciting new adventure book 'The Lost World' by John Smith.", "The Lost World - New Release", book1);
            News news2 = new News("news2.jpg", LocalDate.now(), "Magical tales await in 'Magic in the Forest' by Emily Johnson.", "Magic in the Forest - New Release", book2);
            News news3 = new News("news3.jpg", LocalDate.now(), "The Detective's Secret by Michael Brown is a thrilling read.", "The Detective's Secret - New Release", book3);
            newsRepository.saveAll(List.of(news1, news2, news3));

            genreRepository.findAll().forEach(System.out::println);
            System.out.println();
            authorRepository.findAll().forEach(System.out::println);
            System.out.println();
            publisherRepository.findAll().forEach(System.out::println);
            System.out.println();
            seriesRepository.findAll().forEach(System.out::println);
            System.out.println();
            keywordRepository.findAll().forEach(System.out::println);
            System.out.println();
            accountRepository.findAll().forEach(System.out::println);
            System.out.println();
            bookRepository.findAll().forEach(System.out::println);
            System.out.println();
            loanRepository.findAll().forEach(System.out::println);
            System.out.println();
            newsRepository.findAll().forEach(System.out::println);
            System.out.println();

        };

    }
}
