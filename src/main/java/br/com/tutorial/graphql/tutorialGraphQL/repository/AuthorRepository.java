package br.com.tutorial.graphql.tutorialGraphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tutorial.graphql.tutorialGraphQL.model.Author;

public interface AuthorRepository  extends JpaRepository<Author, Long>{

	

}
