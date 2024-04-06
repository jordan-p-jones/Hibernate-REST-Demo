package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to provide data access methods for Book.
 * Custom methods not pre-implemented by JpaRepository will go here.
 */
public interface BookRepository extends JpaRepository<Book, Long> 
{
	/**
	 * Find all books written by a given author.
	 * 
	 * @param author is the book author to look for.
	 * 
	 * @return all books written by the given author.
	 */
	List<Book> findByAuthor(String author);
}