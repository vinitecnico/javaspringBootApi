package br.com.treinamento.springbootapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.service.BookService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("controller")
public class BookControllerTest {
    @InjectMocks
    BookController bookController;
     
    @Mock
    BookService _bookService;

    @Test
    @DisplayName("Test getById Success")
    public void GetByIdReturnBook() 
    {
        Book book = new Book(1L, "title", "author", "ispb");
        when(_bookService.GetById(1L)).thenReturn(book);
 
        // when
        ResponseEntity<Book> result = bookController.GetById(1l);
 
        // then
        assertEquals(HttpStatus.OK.value(), result.getStatusCode().value());
        assertEquals("title", result.getBody().getTitle());
        assertEquals("author", result.getBody().getAuthor());
        assertEquals("ispb", result.getBody().getIsbn());
    }

    @Test
    @DisplayName("Test getById Not Found")
    public void GetByIdReturnNotFound() 
    {
        Book book = null;
        when(_bookService.GetById(1L)).thenReturn(book);
 
        // when
        ResponseEntity<Book> result = bookController.GetById(1l);
 
        // then
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getStatusCode().value());
        assertEquals(null, result.getBody());
    }
}
