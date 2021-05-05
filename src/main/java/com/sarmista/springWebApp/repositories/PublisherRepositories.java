package com.sarmista.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sarmista.springWebApp.domain.Publisher;

public interface PublisherRepositories extends CrudRepository<Publisher, Long> {

}
