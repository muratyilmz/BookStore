package com.library.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookstore")

public class Library {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "writer")
	private String writer;
	@Column(name = "publisher")
	private String publisher;
	@Column(name = "book")
	private String book;
	@Column(name = "writerdesc")
	private String writerdesc;
	@Column(name="publisdesc")
	private String publisdesc;
	@Column(name="bookdesc")
	private String bookdesc;
	@Column(name="booknumb")
	private String booknumb;
	@Column(name="publisnumber")
	private String publisnumber;
	@Column(name="isbn")
	private String isbn;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisnumber() {
		return publisnumber;
	}
	public void setPublisnumber(String publisnumber) {
		this.publisnumber = publisnumber;
	}
	public String getBooknumb() {
		return booknumb;
	}
	public void setBooknumb(String booknumb) {
		this.booknumb = booknumb;
	}
	
	public String getPublisdesc() {
		return publisdesc;
	}
	public void setPublisdesc(String publisdesc) {
		this.publisdesc = publisdesc;
	}
	public String getBookdesc() {
		return bookdesc;
	}
	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}
	public String getWriterdesc() {
		return writerdesc;
	}
	public void setWriterdesc(String writerdesc) {
		this.writerdesc = writerdesc;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
	
	
}
