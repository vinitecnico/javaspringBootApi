package br.com.treinamento.springbootapi.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.treinamento.springbootapi.entity.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
