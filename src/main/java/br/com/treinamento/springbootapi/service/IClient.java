package br.com.treinamento.springbootapi.service;

import br.com.treinamento.springbootapi.entity.Client;

public interface IClient {
    Client GetById(Long id);
    Client Post (Client book);
}
