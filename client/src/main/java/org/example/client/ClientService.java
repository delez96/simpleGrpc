package org.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloResponse;
import org.example.grpc.HelloServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public HelloResponse callGrpc(String firstName, String lastName) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090")
                .usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub stub2 = HelloServiceGrpc.newBlockingStub(channel);
        return stub2.hello(HelloRequest.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build());
    }
}
