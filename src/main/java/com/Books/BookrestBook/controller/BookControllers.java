package com.Books.BookrestBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Books.BookrestBook.entities.Book;
import com.Books.BookrestBook.service.BookService;

@RestController
@RequestMapping("/get")
public class BookControllers {

	@Autowired
	private BookService bookservice;

	@GetMapping
	public List<Book> getBook() {
		return bookservice.getAllBooks();
	}

//	@GetMapping("/books")
//	public Book getBooks() {
//		Book book = new Book();
//		book.setBookId(1111);
//		book.setBookName("Avneet");
//		book.setBookAuthor("Abhishek");
//		return book;

	@GetMapping("/{id}")
	public Book AddBooks(@PathVariable("id") int id) {
		return bookservice.getBookById(id);
	}

	@PostMapping
	public Book AddBookS(@RequestBody Book book) {
		Book b = this.bookservice.AddBook(book);
		System.out.println(book);
		return b;
	}

	@DeleteMapping("/{id}")
	public String DeleteBooks(@PathVariable("id") int id) {
		bookservice.deleteBookByID(id);
		return "Emoved SuccessFully";

	}

	
	@PutMapping("/{id}")
	public Book UpdateBook(@RequestBody Book book,@PathVariable("id") int id) {
		 this.	bookservice.UpdateBook(book,id);
		 return book;
	}
}
