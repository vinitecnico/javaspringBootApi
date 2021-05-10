package br.com.treinamento.springbootapi.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.treinamento.springbootapi.entity.Client;
import br.com.treinamento.springbootapi.service.ClientService;

/**
 * ClientController
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService _clientService;

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public ResponseEntity<Book> GetById(@PathVariable(value = "id") long id) {
    //     Book book = _bookService.GetById(id);
    //     if (book != null)
    //         return new ResponseEntity<Book>(book, HttpStatus.OK);
    //     else
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    @RequestMapping(method = RequestMethod.POST)
    public Client Post(@RequestBody Client client) {
        return _clientService.Post(client);
    }
}