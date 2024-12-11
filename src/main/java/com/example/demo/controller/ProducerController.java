package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import com.example.demo.producer.DaprProducerNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("dapr")
public class ProducerController {

    @Autowired
    private DaprProducerNew producerNew;

    @PostMapping("/publish")
    public Mono<String> publishMessage(@RequestBody PubSubOptions message) {

        producerNew.publishEvent(message);
        return Mono.just("success");
    }
}
