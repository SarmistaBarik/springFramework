package com.sarmista.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sarmista.springWebApp.domain.Book;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
