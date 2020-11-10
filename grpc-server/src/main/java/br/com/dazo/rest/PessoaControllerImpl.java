package br.com.dazo.rest;

import br.com.dazo.grpc.Pessoa;
import br.com.dazo.grpc.PessoaControllerGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class PessoaControllerImpl extends PessoaControllerGrpc.PessoaControllerImplBase {

//    private static final Logger LOGGER = LoggerFactory.getLogger(PessoaControllerImpl.class);

    private static int id = 1;

    @Override
    public void grava(Pessoa pessoaRequest, StreamObserver<Pessoa> responseObserver) {
//        LOGGER.info("server receive {}", pessoaRequest);
        Pessoa pessoaResponse = Pessoa.newBuilder()
                                    .setId(id)
                                    .setNome(pessoaRequest.getNome())
                                    .setCpf(pessoaRequest.getCpf())
                                    .setEmail(pessoaRequest.getEmail())
                                    .setLogin(pessoaRequest.getLogin())
                                    .build();

        id++;

//        LOGGER.info("server reponded {}", pessoaResponse);
        responseObserver.onNext(pessoaResponse);
        responseObserver.onCompleted();
    }

}