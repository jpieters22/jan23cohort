package com.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booksapi.models.Book;
import com.booksapi.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	// returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // updates a book
    public Book updateBook(Book b) {
    	return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // Deletes a book
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = bookRepo.findById(id).get();
	     if(book != null) {
	            book.setTitle(title);
	            book.setDescription(desc);
	            book.setLanguage(lang);
	            book.setNumberOfPages(numOfPages);
	            return bookRepo.save(book);
	     } else {
		return null;
	     }
	}
}
