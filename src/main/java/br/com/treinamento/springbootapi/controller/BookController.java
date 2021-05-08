package br.com.treinamento.springbootapi.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.entity.Page;
import br.com.treinamento.springbootapi.entity.Pessoa;
import br.com.treinamento.springbootapi.repository.BookRepository;
import br.com.treinamento.springbootapi.repository.PageRepository;
import br.com.treinamento.springbootapi.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Set;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 */
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository _bookRepository;
    @Autowired
    private PageRepository _pageRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> GetById(@PathVariable(value = "id") long id) {
        Optional<Book> book = _bookRepository.findById(id);
        if (book.isPresent())
            return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book Post(@RequestBody Book book) {
        // create a new book
        Book _book = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());

        // save the book
        _bookRepository.save(_book);

        for (Page page : book.getPages()) {
            Page _page = new Page(page.getId(), 1, page.getContent(), page.getChapter(), _book);
            _pageRepository.save(_page);
        }

        return _book;
    }
}