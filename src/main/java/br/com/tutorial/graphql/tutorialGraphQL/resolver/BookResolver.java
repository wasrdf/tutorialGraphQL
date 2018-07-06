package br.com.tutorial.graphql.tutorialGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.tutorial.graphql.tutorialGraphQL.model.Author;
import br.com.tutorial.graphql.tutorialGraphQL.model.Book;
import br.com.tutorial.graphql.tutorialGraphQL.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
	
	
	private AuthorRepository authorRepository;
	
	
	

    public BookResolver(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
	
}
