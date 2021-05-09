package br.com.treinamento.springbootapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.entity.Page;
import br.com.treinamento.springbootapi.repository.BookRepository;
import br.com.treinamento.springbootapi.repository.PageRepository;

@Service
public class BookService implements Ibook {
    @Autowired
    private BookRepository _bookRepository;
    @Autowired
    private PageRepository _pageRepository;

    @Override
    public Book GetById(Long id) {
        Optional<Book> book = _bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public Book Post(Book book) {
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
