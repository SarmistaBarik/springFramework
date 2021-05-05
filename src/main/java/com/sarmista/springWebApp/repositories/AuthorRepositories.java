package com.sarmista.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sarmista.springWebApp.domain.Author;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
