package com.greatlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	public List<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name, String author);
	
}
