package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloResponse;
import org.example.grpc.HelloServiceGrpc;

public class SimpleApp {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:9090")
                .usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub stub2 = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse anatoly = stub2.hello(HelloRequest.newBuilder()
                .setFirstName("ANATOLY")
                .setLastName("KURILOV")
                .build());
        System.out.println(anatoly);
    }
}
