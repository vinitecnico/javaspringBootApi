package br.com.treinamento.springbootapi.service;

import br.com.treinamento.springbootapi.entity.Book;

public interface Ibook {
    Book GetById(Long id);
    Book Post (Book book);
}
