package br.com.dazo.grpc;

import br.com.dazo.stream.MensagemInput;
import br.com.dazo.stream.MensagemOutput;
import br.com.dazo.stream.StreamControllerGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class StreamControllerImpl extends StreamControllerGrpc.StreamControllerImplBase {

    @Override
    public void serverSideStream(MensagemInput request, StreamObserver<MensagemOutput> responseObserver) {
        for (int i = 1; i <= 5; i++) {
            MensagemOutput mensagemOutput = MensagemOutput.newBuilder()
                    .setDado(request.getDado() + " - teste: "+i)
                    .build();
            responseObserver.onNext(mensagemOutput);
        }
        responseObserver.onCompleted();
    }
}
