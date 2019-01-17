/**
 * 
 */
package com.mybook.app.bookapi.service;

import java.util.List;
import java.util.Optional;

import com.mybook.app.bookapi.model.Book;

/**
 * @author 35389
 *
 */
public interface BookService {

	Book save(Book book);

	Optional<Book> findById(Long id);

	List<Book> findAll();

	void deleteById(Long id);
	
	//Optional<List<Book>> findByAuthor(String author);

}
