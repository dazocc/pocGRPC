package br.com.dazo.rest;

import java.util.List;

public class GeradorPessoa {

    public static List<Pessoa> geraPessoa(){
        return List.of(
                new Pessoa("Davison Oliveira",
                           "344.725.450-55",
                           "davison.oliveira@gmail.com",
                           "davison.oliveira"));
    }

}
