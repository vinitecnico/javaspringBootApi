package br.com.treinamento.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.springbootapi.entity.Pessoa;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }
