package org.example.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloResponse;
import org.example.grpc.HelloServiceGrpc;

@GrpcService
public class SimpleServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello, " + request.getFirstName() + " " + request.getLastName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}