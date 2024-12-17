package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import com.example.demo.producer.DaprConsumerNew;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import io.dapr.client.domain.PublishEventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("dapr")
public class ConsumerController {

    @Autowired
    private DaprConsumerNew daprConsumerNew;

    @PostMapping("/consume")
    @Topic(pubsubName = "kafka-pubsub", name = "test-topic")
    public Mono<String> consume(@RequestBody CloudEvent<Object> event) {
        log.info("consume data {}", event.getData());
        return Mono.just("consume success");
    }
}
