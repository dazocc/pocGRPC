package br.com.dazo.client;

import br.com.dazo.grpc.Pessoa;
import br.com.dazo.stream.MensagemInput;
import br.com.dazo.stream.MensagemOutput;
import br.com.dazo.stream.StreamControllerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;

public class StreamClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        StreamControllerGrpc.StreamControllerStub stub = StreamControllerGrpc.newStub(channel);
        StreamControllerGrpc.StreamControllerBlockingStub blockinStub = StreamControllerGrpc.newBlockingStub(channel);

        serverSideStream(blockinStub);

        channel.shutdown();
    }

    public static void serverSideStream(StreamControllerGrpc.StreamControllerBlockingStub blockinStub) {

        MensagemInput mensagemInput = MensagemInput.newBuilder()
                .setDado("Teste 1")
                .build();

        Iterator<MensagemOutput> listMensagemOutput =  blockinStub.serverSideStream(mensagemInput);

        listMensagemOutput.forEachRemaining(mensagemOutput -> {
            System.out.println(mensagemOutput.getDado());
        });
    }
}
