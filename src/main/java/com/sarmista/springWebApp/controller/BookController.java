package com.sarmista.springWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarmista.springWebApp.repositories.BookRepositories;

@Controller
public class BookController {
	
	private final BookRepositories bookRepositories;
	
	
	
public BookController(BookRepositories bookRepositories) {
		super();
		this.bookRepositories = bookRepositories;
	}



@RequestMapping("/books")
public String getBook(Model model) {
	
	model.addAttribute("books", bookRepositories.findAll());
	
	return "books/list";
	
}
}
