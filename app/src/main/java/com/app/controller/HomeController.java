package com.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.modals.Book;
import com.app.service.AppService;

@Controller
public class HomeController {

	@Autowired 
	AppService appService;
	
	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("books", appService.getBooks());
		request.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("book", appService.getBook(id));
		request.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@PostMapping("/save")
	public void save(@ModelAttribute Book book,HttpServletRequest request,HttpServletResponse response){
		appService.save(book);
		request.setAttribute("mode", "BOOK_VIEW");
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/add")
	public String add(HttpServletRequest request) {
		request.setAttribute("mode","BOOK_ADD");
		return "index";
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam int id,HttpServletResponse response) {
		appService.delete(id);
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
