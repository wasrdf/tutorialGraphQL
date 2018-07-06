package br.com.tutorial.graphql.tutorialGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.tutorial.graphql.tutorialGraphQL.model.Author;
import br.com.tutorial.graphql.tutorialGraphQL.model.Book;
import br.com.tutorial.graphql.tutorialGraphQL.repository.AuthorRepository;
import br.com.tutorial.graphql.tutorialGraphQL.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {

	
	private BookRepository bookRepository;
	
	public Mutation(AuthorRepository authorRepository ,BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	private AuthorRepository authorRepository;
	
	public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }
	
	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }
	
	public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }
	
	public Book findBookById(Long id) {
		return bookRepository.findOne(id);
	}
	
	public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        
        if(book == null) {
        	throw new BookNotFoundException("The book to be update was not found", id);
        }
        
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
	

}
