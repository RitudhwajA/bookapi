/**
 * 
 */
package com.mybook.app.bookapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybook.app.bookapi.model.Book;

/**
 * @author 35389
 *
 */
public interface BookDAO extends JpaRepository<Book, Long> {

	// Optional<List<Book>> findByAuthorIgnoreCase(String author);
}
