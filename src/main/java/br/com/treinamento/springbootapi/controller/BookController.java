package br.com.treinamento.springbootapi.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.service.BookService;

/**
 * BookController
 */
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService _bookService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> GetById(@PathVariable(value = "id") long id) {
        Book book = _bookService.GetById(id);
        if (book != null)
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> Post(@RequestBody Book book) {
        return new ResponseEntity<Book>(_bookService.Post(book), HttpStatus.CREATED);
    }
}