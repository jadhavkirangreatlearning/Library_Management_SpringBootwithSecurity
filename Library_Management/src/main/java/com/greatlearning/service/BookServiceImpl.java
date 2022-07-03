package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Book;
import com.greatlearning.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		
		bookRepository.save(book);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> searchBy(String name, String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(name, author);
	}

}
