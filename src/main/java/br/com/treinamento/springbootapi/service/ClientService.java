package br.com.treinamento.springbootapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.springbootapi.entity.Client;
import br.com.treinamento.springbootapi.entity.Product;
import br.com.treinamento.springbootapi.repository.ClientRepository;
import br.com.treinamento.springbootapi.repository.ProductRepository;

@Service
public class ClientService implements IClient {
    @Autowired
    private ClientRepository _clientRepository;
    @Autowired
    private ProductRepository _productRepository;

    @Override
    public Client GetById(Long id) {
        // Optional<Book> book = _bookRepository.findById(id);
        // if (book.isPresent()) {
        // return book.get();
        // }
        return null;
    }

    @Override
    public Client Post(Client client) {
        // create a student
        Client _client = new Client("test", 10);

        _clientRepository.save(_client);

        // create three courses
        Product product1 = new Product("Machine Learning", 12.0, "ML");
        Product product2 = new Product("Database Systems", 8.0, "DS");
        Product product3 = new Product("Web Basics", 10.0, "WB");

        // save products
        _productRepository.saveAll(Arrays.asList(product1, product2, product3));

        // add courses to the client
        _client.products.addAll(Arrays.asList(product1, product2, product3));

        // update the student
        _clientRepository.save(_client);

        return _client;
    }

}
