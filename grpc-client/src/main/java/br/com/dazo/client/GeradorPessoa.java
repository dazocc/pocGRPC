package br.com.dazo.client;

import br.com.dazo.rest.Pessoa;

import java.util.List;

public class GeradorPessoa {

    public static List<Pessoa> geraPessoa(){
        return List.of(Pessoa.newBuilder()
                .setNome("Davison Oliveira")
                .setCpf("344.725.450-55")
                .setEmail("davison.oliveira@gmail.com")
                .setLogin("davison.oliveira")
                .build());
    }

}
