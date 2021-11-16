package br.com.dazo.client;

import br.com.dazo.grpc.Pessoa;
import br.com.dazo.grpc.PessoaControllerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class GrpcClient {

//    public static void main(String[] args) {
//
//        int executar = 10000;
//
//        Instant start = Instant.now();
//
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
//                .usePlaintext()
//                .build();
//
//        PessoaControllerGrpc.PessoaControllerBlockingStub stub
//                = PessoaControllerGrpc.newBlockingStub(channel);
//
//        Pessoa pessoa = Pessoa.newBuilder()
//                .setNome("Davison Oliveira")
//                .setCpf("344.725.450-55")
//                .setEmail("davison.oliveira@gmail.com")
//                .setLogin("davison.oliveira")
//                .build();
//
//        for (int i = 0; i < executar; i++) {
//            Pessoa pessoaResponse = stub.grava(pessoa);
//            System.out.println(pessoaResponse.getId());
//        }
//
//        channel.shutdown();
//
//        Instant finish = Instant.now();
//        float timeElapsed = Duration.between(start, finish).toMillis();
//        System.out.println(timeElapsed/1000 + " segundos");
//    }
}
