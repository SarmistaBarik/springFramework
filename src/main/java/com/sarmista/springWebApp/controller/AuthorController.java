package com.sarmista.springWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarmista.springWebApp.repositories.AuthorRepositories;

@Controller
public class AuthorController {
	
	private final AuthorRepositories authorRepositories;

	public AuthorController(AuthorRepositories authorRepositories) {
		super();
		this.authorRepositories = authorRepositories;
	}
	
	@RequestMapping("/author")
	public String getAuthor(Model model) {
		
		model.addAttribute("author", authorRepositories.findAll());
		
		return "author/list";
		
	}

}
