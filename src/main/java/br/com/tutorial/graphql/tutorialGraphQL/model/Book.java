package br.com.tutorial.graphql.tutorialGraphQL.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2857218836601617183L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String isbn;

	private int pageCount;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;

	public Book() {
	}

	public Book(String title, String isbn, int pageCount, Author author) {
		this.title = title;
		this.isbn = isbn;
		this.pageCount = pageCount;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		return id.equals(book.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", title='" + title + '\'' + ", isbn='" + isbn + '\'' + ", pageCount=" + pageCount
				+ ", author=" + author + '}';
	}
}