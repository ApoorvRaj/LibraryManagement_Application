package com.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.modals.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer>{

}
