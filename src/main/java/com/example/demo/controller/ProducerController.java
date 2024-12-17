package com.example.demo.controller;

import com.example.demo.dto.InvokeBindingDTO;
import com.example.demo.dto.PubSubOptions;
import com.example.demo.producer.DaprProducerNew;
import com.fasterxml.jackson.databind.JsonNode;
import io.dapr.client.DaprClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
//import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    private DaprProducerNew producerNew;

    @Autowired
    private DaprClient daprClient;

    @PostMapping("/publish")
    public Mono<Void> publishMessage(@RequestBody PubSubOptions message) {

        log.info("entered publishMessage {}", message);
        return producerNew.publishEvent(message);
    }

}
