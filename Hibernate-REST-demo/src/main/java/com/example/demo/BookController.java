package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class to define REST mappings for interaction with Book records.
 */
@RestController
@RequestMapping("/books")
public class BookController 
{
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() 
    {
        return this.bookRepository.findAll();
    }
    
    @DeleteMapping("/deleteAll")
    public void deleteAllBooks()
    {
    	this.bookRepository.deleteAll();
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) 
    {
        return this.bookRepository.save(book);
    }
    
    @PostMapping("/update")
    public void updateBook(@RequestBody Book book)
    {
    	Optional<Book> bookToUpdate = this.bookRepository.findById(book.getId());
    	
    	if( bookToUpdate.isPresent() )
    	{
    		bookToUpdate.get().updateValues(book);
    		this.bookRepository.save(bookToUpdate.get());
    	}
    }
    
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable("author") String author) 
    {
        return this.bookRepository.findByAuthor(author);
    }
}
