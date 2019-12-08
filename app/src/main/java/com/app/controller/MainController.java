package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.modals.Book;
import com.app.service.AppService;

@RestController
public class MainController {

	@Autowired 
	AppService appService;
	
	@GetMapping(value="/books")
	public List<Book> getBooks(){
		return appService.getBooks();
	}
	
	@GetMapping(value="/deletebook/{id}")
	public void delete(@PathVariable("id")int id) {
		appService.delete(id);
	}
	
	
}
