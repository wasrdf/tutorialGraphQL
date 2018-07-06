package br.com.tutorial.graphql.tutorialGraphQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.tutorial.graphql.tutorialGraphQL.repository.AuthorRepository;
import br.com.tutorial.graphql.tutorialGraphQL.repository.BookRepository;
import br.com.tutorial.graphql.tutorialGraphQL.resolver.BookResolver;
import br.com.tutorial.graphql.tutorialGraphQL.resolver.Mutation;
import br.com.tutorial.graphql.tutorialGraphQL.resolver.Query;

@SpringBootApplication
public class TutorialGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialGraphQlApplication.class, args);
	}
	
	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}
	
}
