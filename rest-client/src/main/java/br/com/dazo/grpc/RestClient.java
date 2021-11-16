package br.com.dazo.grpc;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class RestClient {

    public static void main(String[] args) {

        int executar = 10000;

        Instant start = Instant.now();

        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://localhost:8081/pessoa";

        Pessoa pessoa = new Pessoa("Davison Oliveira",
                "344.725.450-55",
                "davison.oliveira@gmail.com",
                "davison.oliveira");

        for (int i = 0; i < executar; i++) {
            HttpEntity<Pessoa> pessoaRequest = new HttpEntity<>(pessoa);
            Pessoa pessoaResponse = restTemplate.postForObject(uri, pessoaRequest, Pessoa.class);
            System.out.println(pessoaResponse.getId());
        }

        Instant finish = Instant.now();
        float timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed/1000 + " segundos");
    }

}
