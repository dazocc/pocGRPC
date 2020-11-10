package br.com.dazo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaControllerImpl {

    private static int id = 1;

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoaRequest) {

        Pessoa pessoaResponse = new Pessoa();

        pessoaResponse.setId(id);
        pessoaResponse.setNome(pessoaRequest.getNome());
        pessoaResponse.setCpf(pessoaRequest.getCpf());
        pessoaResponse.setEmail(pessoaRequest.getEmail());
        pessoaResponse.setLogin(pessoaRequest.getLogin());

        id++;

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }

}