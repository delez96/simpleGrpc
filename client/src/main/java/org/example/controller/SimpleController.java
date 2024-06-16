package org.example.controller;

import org.example.client.ClientService;
import org.example.grpc.HelloResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {

    private final ClientService service;

    public SimpleController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/grpc", method = RequestMethod.GET)
    public HelloResponse callGrpc(@RequestParam String lastName, @RequestParam String firstName) {
        return service.callGrpc(firstName, lastName);
    }
}
