package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.app.dao.BookRepo;
import com.app.modals.Book;

@Service
public class AppService {

	@Autowired
	BookRepo bookRepo;
	
	public List<Book> getBooks(){
		
		List<Book> books = new ArrayList<Book>();
		books = (List<Book>) bookRepo.findAll();
		return books;
	}
	
	public void delete(int id) {
		bookRepo.deleteById(id);
	}

	public Book getBook(int id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else
			return null;
	}
	
	public void save(Book book) {
		bookRepo.save(book);
	}
}
