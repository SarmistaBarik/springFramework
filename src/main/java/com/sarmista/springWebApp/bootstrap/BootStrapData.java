package com.sarmista.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sarmista.springWebApp.domain.Author;
import com.sarmista.springWebApp.domain.Book;
import com.sarmista.springWebApp.domain.Publisher;
import com.sarmista.springWebApp.repositories.AuthorRepositories;
import com.sarmista.springWebApp.repositories.BookRepositories;
import com.sarmista.springWebApp.repositories.PublisherRepositories;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepository;
    private final BookRepositories bookRepository;
    private final PublisherRepositories publisherRepositories;

    public BootStrapData(AuthorRepositories authorRepository, BookRepositories bookRepository,
    		PublisherRepositories publisherRepositories) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
		this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	 Publisher publisher = new Publisher();
         publisher.setName("times");
         publisher.setAddressLine1("nandanvihar");
         publisher.setCity("bhubaneswar");
         publisher.setState("Odisha");
         publisher.setZip("751024");
         
         publisherRepositories.save(publisher);
         
         System.out.println("Publisher Count: " + publisherRepositories.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepositories.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepositories.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Count of books : " + publisher.getBooks().size());
        
       
        
    }
}