package br.com.dazo.client;

import br.com.dazo.rest.Pessoa;
import br.com.dazo.rest.PessoaControllerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class GrpcClient {

    public static void main(String[] args) {
        
        int executar = 10000;

        Instant start = Instant.now();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        PessoaControllerGrpc.PessoaControllerBlockingStub stub
                = PessoaControllerGrpc.newBlockingStub(channel);

        List<Pessoa> listPessoa = GeradorPessoa.geraPessoa();

        for (int i = 0; i < executar; i++) {
            listPessoa.forEach(pessoa -> {
                Pessoa pessoaResponse = stub.grava(pessoa);
                System.out.println(pessoaResponse.getId());
            });
        }

        channel.shutdown();

        Instant finish = Instant.now();
        float timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed/1000 + " segundos");
    }
}
