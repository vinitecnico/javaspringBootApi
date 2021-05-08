package br.com.treinamento.springbootapi.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.entity.Page;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}
