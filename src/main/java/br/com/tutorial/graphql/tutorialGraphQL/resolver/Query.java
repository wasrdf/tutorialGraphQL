package br.com.tutorial.graphql.tutorialGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.tutorial.graphql.tutorialGraphQL.model.Author;
import br.com.tutorial.graphql.tutorialGraphQL.model.Book;
import br.com.tutorial.graphql.tutorialGraphQL.repository.AuthorRepository;
import br.com.tutorial.graphql.tutorialGraphQL.repository.BookRepository;

public class Query implements GraphQLQueryResolver {

	
	private AuthorRepository authorRepository;
	
	private BookRepository bookRepository;
	
	
	

	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
	
	public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}
