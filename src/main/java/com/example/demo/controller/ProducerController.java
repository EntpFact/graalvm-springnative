package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import com.example.demo.producer.DaprProducerNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
//import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("dapr")
public class ProducerController {

    @Autowired
    private DaprProducerNew producerNew;

    @PostMapping("/publish")
    public Mono<Void> publishMessage(@RequestBody PubSubOptions message) {

        log.info("entered publishMessage {}", message);
        return producerNew.publishEvent(message);
    }

    @GetMapping("/message")
    public Mono<String> getMessage() {

        log.info("entered getMessage");
        return  Mono.just("message");
    }
}
