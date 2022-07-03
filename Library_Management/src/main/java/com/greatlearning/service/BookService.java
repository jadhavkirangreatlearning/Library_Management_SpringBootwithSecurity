package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.entity.Book;

public interface BookService {
	
	public List<Book> findAll();
	
	public Optional<Book> findById(int id);
	
	public void save(Book book);
	
	public void deleteById(int id);
	
	public List<Book> searchBy(String name, String author);

}
