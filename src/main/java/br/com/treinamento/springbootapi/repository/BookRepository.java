package br.com.treinamento.springbootapi.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.treinamento.springbootapi.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);
}
