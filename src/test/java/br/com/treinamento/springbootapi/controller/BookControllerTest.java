package br.com.treinamento.springbootapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.treinamento.springbootapi.AbstractTest;
import br.com.treinamento.springbootapi.entity.Book;
import br.com.treinamento.springbootapi.service.BookService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("controller")
public class BookControllerTest extends AbstractTest {
    @InjectMocks
    BookController bookController;
                                                 
    @MockBean                           
    private BookService _bookService;

    @Test
    @DisplayName("Test Create Book Return Success")
    public void CreateBookReturnSuccess() throws Exception {
        String uri = "/api/book";
        Book book = new Book(1L, "title", "author", "ispb");

        when(_bookService.Post(isA(Book.class)))
         .thenReturn(book);

        String inputJson = super.mapToJson(book);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(inputJson))
        .andReturn()
        .getResponse();

        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        Book bookResponse = mapFromJson(response.getContentAsString(), Book.class);
        assertEquals(bookResponse.getId(), 1L);
        assertEquals(bookResponse.getTitle(), "title");
        assertEquals(bookResponse.getAuthor(), "author");
        assertEquals(bookResponse.getIsbn(), "ispb");
    }
}
