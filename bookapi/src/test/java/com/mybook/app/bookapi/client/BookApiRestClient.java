package com.mybook.app.bookapi.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mybook.app.bookapi.model.Book;

public class BookApiRestClient {

	public BookApiRestClient() {
		// TODO Auto-generated constructor stub
	}

	public void getBookById() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/books/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Book> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book.class, 1);
		Book book = responseEntity.getBody();
		System.out.println(book.toString());
	}

	public void getAllBooks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/books";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book[].class);
		Book[] books = responseEntity.getBody();
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public void addBook() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/books";
		Book book = new Book();
		book.setTitle("added through client");
		book.setAuthor("Ritudhwaj");
		HttpEntity<Book> requestEntity = new HttpEntity<Book>(book, headers);
		ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Book[].class);
		//URI uri = restTemplate.postForLocation(url, requestEntity);
		//System.out.println(uri.getPath());
		System.out.println(responseEntity.getBody());
	}

	public void updateBook() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/books/{id}";
		Book book = new Book("uodated through client", "dhwaj again");
		HttpEntity<Book> requestEntity = new HttpEntity<Book>(book, headers);
		ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Book[].class,1);
		//restTemplate.put(url, requestEntity);
	}

	public void deleteBook() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/books/{id}";
		HttpEntity<Book> requestEntity = new HttpEntity<Book>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}
	
	/*public void GetBookByAuthor() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/books/{author}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Book> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book.class, "dhwaj5");
		Book book = responseEntity.getBody();
		System.out.println(book.toString());
	}*/

	public static void main(String args[]) {
		BookApiRestClient client = new BookApiRestClient();
		client.getAllBooks();
		client.getBookById();
		client.addBook();
		client.updateBook();
		client.deleteBook();
		//client.GetBookByAuthor();
	}
}
