package com.example.demo;
import jakarta.persistence.*;

/**
 * Class to represent a book business object.
 */
@Entity
public class Book 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "edition")
    private Integer edition;
    
    @Column(name = "year")
    private Integer year;

	public Book() {}
    
    /**
	 * Constructor for Book.
	 * 
	 * @param title is the book title.
	 * @param author is the book author.
	 * @param edition is the book edition.
	 * @param year is the book publish year.
	 */
	public Book(String title, String author, Integer edition, Integer year) 
	{
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.year = year;
	}
	
	/**
	 * Update the values of this book with those in the given book.
	 * 
	 * @param newBook is the book whose values will be used for update.
	 */
	public void updateValues(Book newBook)
	{
		this.title  = newBook.getTitle();
		this.author = newBook.getAuthor();
		this.edition = newBook.getEdition();
		this.year = newBook.getYear();
	}

	/**
	 * Get the id.
	 *
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Set the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Get the title.
	 *
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Set the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Get the author.
	 *
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Set the author.
	 *
	 * @param author the author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Get the edition.
	 *
	 * @return the edition
	 */
	public Integer getEdition()
	{
		return edition;
	}

	/**
	 * Set the edition.
	 *
	 * @param edition the edition to set
	 */
	public void setEdition(Integer edition)
	{
		this.edition = edition;
	}

	/**
	 * Get the year.
	 *
	 * @return the year
	 */
	public Integer getYear()
	{
		return year;
	}

	/**
	 * Set the year.
	 *
	 * @param year the year to set
	 */
	public void setYear(Integer year)
	{
		this.year = year;
	}
}
