package com.Books.BookrestBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Books.BookrestBook.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(1, "Java Book Learning First Addtion", "James Gosling"));
		list.add(new Book(2, "Python Book FirstAddition", "Avneet Kaur"));
		list.add(new Book(3, "AI Artificial Integillence First Addition", "Abhishek Vyawhare"));

	}

	// get All books
	public List<Book> getAllBooks() {
		return list;
	}

	// get Single Book Id
	public Book getBookById(int id) {

		Book book = null;
		book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
		return book;
	}

	// Add Book
	public Book AddBook(Book b) {
		list.add(b);
		return b;
	}

	// elete By
	public void deleteBookByID(int id) {
		list = list.stream().filter(e -> e.getBookId() != id).collect(Collectors.toList());

	}

	// Update The Book
	public void UpdateBook(Book book, int id) {

		list = list.stream().map(e -> {
			if (e.getBookId() == id) {
				e.setBookName(book.getBookName());
				e.setBookAuthor(book.getBookAuthor());
			}
			return e;
		}).collect(Collectors.toList());
	}
}
