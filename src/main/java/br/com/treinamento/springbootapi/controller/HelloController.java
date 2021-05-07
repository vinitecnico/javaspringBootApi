package br.com.treinamento.springbootapi.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.springbootapi.entity.Pessoa;
import br.com.treinamento.springbootapi.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * HelloController
 */
@RestController
public class HelloController {
    @Autowired
    private PessoaRepository _pessoaRepository;
    
    @GetMapping(value="/")
    public String getMethodName() {
        return "hello world";
    }
    
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Pessoa Post(@RequestBody Pessoa pessoa)
    {
        return _pessoaRepository.save(pessoa);
    }
    
}