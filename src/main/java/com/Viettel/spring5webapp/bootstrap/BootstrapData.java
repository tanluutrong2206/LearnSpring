package com.Viettel.spring5webapp.bootstrap;

import com.Viettel.spring5webapp.domain.Author;
import com.Viettel.spring5webapp.domain.Book;
import com.Viettel.spring5webapp.domain.Publisher;
import com.Viettel.spring5webapp.repositories.AuthorRepository;
import com.Viettel.spring5webapp.repositories.BookRepository;
import com.Viettel.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author tanluutrong = new Author("Tấn", "Lưu Trọng");
        Book harryPorter = new Book("Harry Porter", "Hello World");
        Publisher kimDong = new Publisher("Kim Dong", "Ha Noi", "Ha Dong", "Viet Nam", "100000");
        publisherRepository.save(kimDong);


        tanluutrong.getBooks().add(harryPorter);
        harryPorter.setPublisher(kimDong);
        harryPorter.getAuthors().add(tanluutrong);
        kimDong.getBooks().add(harryPorter);

        authorRepository.save(tanluutrong);
        bookRepository.save(harryPorter);

        Author tanluutrong1 = new Author("Tấn 1", "Lưu Trọng");
        Book harryPorter1 = new Book("Harry Porter 1", "Hello World 1");

        tanluutrong1.getBooks().add(harryPorter1);
        harryPorter1.setPublisher(kimDong);
        harryPorter1.getAuthors().add(tanluutrong1);
        kimDong.getBooks().add(harryPorter1);

        authorRepository.save(tanluutrong1);
        bookRepository.save(harryPorter1);
        publisherRepository.save(kimDong);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publisher: " + publisherRepository.count());
        System.out.println("Number of books of the publisher: " + kimDong.getBooks().size());
    }
}
