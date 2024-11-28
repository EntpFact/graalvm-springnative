package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import com.example.demo.producer.DaprProducerNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProducerController {

    @Autowired
    private DaprProducerNew producerNew;

    public Mono<Void> publishMessage(@RequestBody PubSubOptions message) {

        return producerNew.publishEvent(message);
    }
}
