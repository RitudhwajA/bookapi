package com.mybook.app.bookapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybook.app.bookapi.dao.BookDAO;
import com.mybook.app.bookapi.model.Book;

@SpringBootApplication
public class BookapiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookapiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookDAO bookDao) {
		return (args) -> {
			// save a couple of customers
			bookDao.save(new Book("book1", "dhwaj"));
			bookDao.save(new Book("book2", "dhwaj2"));
			bookDao.save(new Book("book3", "dhwaj3"));
			bookDao.save(new Book("book4", "dhwaj4"));
			bookDao.save(new Book("book5", "dhwaj5"));

			// fetch all customers
			
			for (Book book : bookDao.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			bookDao.findById(1L)
				.ifPresent(book -> {
					log.info("Book found with findById(1L):");
					log.info("--------------------------------");
					log.info(book.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Book update with ID 1");
			log.info("--------------------------------------------");
			//bookDao.update(1L);
			log.info("");
			log.info("Book delete with ID 2");
			log.info("--------------------------------------------");
			bookDao.deleteById(2L);
			log.info("--------------------------------------------");
			log.info("--------------------printing all books-----------------------");
			
			for (Book book : bookDao.findAll()) {
				log.info(book.toString());
			}
			log.info("");
		};

}
}

