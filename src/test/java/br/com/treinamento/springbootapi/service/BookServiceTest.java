package br.com.treinamento.springbootapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.repository.BookRepository;
import br.com.treinamento.springbootapi.repository.PageRepository;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository _bookRepository;
    @Mock
    private PageRepository _pageRepository;

    @Test
    @DisplayName("Test getById Success")

    public void GetByIdReturnBook() {
        Book book = new Book(1L, "title", "author", "ispb");
        doReturn(Optional.of(book)).when(_bookRepository).findById(1l);

        Book response = bookService.GetById(1L);
        assertEquals(1L, response.getId());
    }

    @Test
    @DisplayName("Test getById Not Found")
    public void GetByIdReturnNotFound() {
        doReturn(Optional.empty()).when(_bookRepository).findById(1l);

        Book response = bookService.GetById(1L);
        assertEquals(null, response);
    }
}
