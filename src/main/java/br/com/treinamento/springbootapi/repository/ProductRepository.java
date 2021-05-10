package br.com.treinamento.springbootapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.treinamento.springbootapi.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
}