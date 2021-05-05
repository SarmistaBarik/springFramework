package com.sarmista.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sarmista.springWebApp.domain.Author;
import com.sarmista.springWebApp.domain.Book;
import com.sarmista.springWebApp.repositories.AuthorRepositories;
import com.sarmista.springWebApp.repositories.BookRepositories;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepository;
    private final BookRepositories bookRepository;

    public BootStrapData(AuthorRepositories authorRepository, BookRepositories bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}