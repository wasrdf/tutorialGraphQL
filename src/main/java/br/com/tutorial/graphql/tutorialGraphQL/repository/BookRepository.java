package br.com.tutorial.graphql.tutorialGraphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tutorial.graphql.tutorialGraphQL.model.Book;

public interface BookRepository  extends JpaRepository<Book, Long>{

}
