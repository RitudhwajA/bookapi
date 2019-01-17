/**
 * 
 */
package com.mybook.app.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybook.app.bookapi.dao.BookDAO;
import com.mybook.app.bookapi.model.Book;

/**
 * @author 35389
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDao;

	/**
	 * 
	 */
	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.mybook.app.bookapi.service.BookService#save(com.mybook.app.bookapi.model.Book)
	 */
	@Override
	public Book save(Book book) {
		return bookDao.save(book);
	}

	/* (non-Javadoc)
	 * @see com.mybook.app.bookapi.service.BookService#findById(java.lang.Long)
	 */
	@Override
	public Optional<Book> findById(Long id) {
		return bookDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.mybook.app.bookapi.service.BookService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.mybook.app.bookapi.service.BookService#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long id) {
		bookDao.deleteById(id);
	}

	/*@Override
	public Optional<List<Book>> findByAuthor(String author) {
		return bookDao.findByAuthorIgnoreCase(author);
	}
*/
}
