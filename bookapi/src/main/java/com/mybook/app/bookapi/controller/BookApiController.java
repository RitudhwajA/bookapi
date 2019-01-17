/**
 * 
 */
package com.mybook.app.bookapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybook.app.bookapi.model.Book;
import com.mybook.app.bookapi.service.BookService;

/**
 * @author 35389
 *
 */
@RestController
public class BookApiController {
	
	@Autowired
	private BookService bookService;

	/**
	 * 
	 */
	public BookApiController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
		Optional<Book> book = bookService.findById(id);
		if (!book.isPresent())
			return ResponseEntity.notFound().build();
		return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
	}
	
	/*@GetMapping("/books")
	public ResponseEntity<List<Book>> getBookById(@RequestParam("author") String author) {
		Optional<List<Book>> book = bookService.findByAuthor(author);
		if (!book.isPresent())
			return ResponseEntity.notFound().build();
		return new ResponseEntity<List<Book>>(book.get(),HttpStatus.OK);
	}*/

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		bookService.save(book);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/books/{id}")		
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable Long id) {
		if (!bookService.findById(id).isPresent())
			return ResponseEntity.notFound().build();

		book.setId(id);
		bookService.save(book);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable Long id){
		if(!bookService.findById(id).isPresent()) 
			return ResponseEntity.notFound().build();
		bookService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
