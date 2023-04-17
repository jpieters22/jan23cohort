package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	public Book findBook(Long id) {
		Optional<Book> bookList = bookRepo.findById(id);
		if(bookList.isPresent()) {
			return bookList.get();
		}
		return null;
	}
}
