package br.com.treinamento.springbootapi.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.springbootapi.entity.Pessoa;
import br.com.treinamento.springbootapi.repository.PessoaRepository;
import io.swagger.annotations.ApiOperation;

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

/**
 * HelloController
 */
@RestController
@RequestMapping("/api/pessoa")
public class HelloController {
    @Autowired
    private PessoaRepository _pessoaRepository;
    
    @GetMapping(value="/")
    public String getMethodName() {
        return "hello world";
    }
    
    @ApiOperation(value = "Returns a list of people")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public Pessoa Post(@RequestBody Pessoa pessoa)
    {
        return _pessoaRepository.save(pessoa);
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            _pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            _pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}