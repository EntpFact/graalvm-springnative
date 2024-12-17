package com.example.demo.controller;

import com.example.demo.dto.PubSubData;
import com.fasterxml.jackson.databind.JsonNode;
import io.dapr.Topic;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.CloudEvent;
import io.dapr.client.domain.HttpExtension;
import io.dapr.client.domain.InvokeBindingRequest;
import io.dapr.client.domain.InvokeMethodRequest;
import io.dapr.utils.TypeRef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private DaprClient daprClient;

    @PostMapping("/consume")
    @Topic(pubsubName = "kafka-pubsub", name = "test-topic")
    public Mono<String> consume(@RequestBody CloudEvent<PubSubData> event) {
        log.info("consume data {}", event.getData());
        return Mono.just("consume success");
    }

    /**
     * consume message and invoke binding
     * @param event
     * @return
     */
    @PostMapping("/consume/invokeBinding")
    @Topic(pubsubName = "kafka-pubsub", name = "test-topic")
    public Mono<JsonNode> process1(@RequestBody CloudEvent<PubSubData> event) {
        log.info("process1 data {}", event.getData());

        InvokeBindingRequest invokeMethodRequest = new InvokeBindingRequest("service2-http-binding", "get")
                .setMetadata(Map.of("path", "/message?message="+event.getData().getInput()));

        TypeRef<JsonNode> typeRef = new TypeRef<JsonNode>() {};
        return daprClient.invokeBinding(invokeMethodRequest, typeRef)
                .doOnSuccess(response -> log.info("process success response {}", response))
                .doOnError(e -> log.error("process failure error ", e));

    }

    /**
     * consume message and invoke method (non dapr endpoint)
     * @param event
     * @return
     */
    @PostMapping("/consume/invokeMethod")
    @Topic(pubsubName = "kafka-pubsub", name = "test-topic")
    public Mono<JsonNode> process2(@RequestBody CloudEvent<PubSubData> event) {
        log.info("process2 data {}", event.getData());

        InvokeMethodRequest invokeMethodRequest = new InvokeMethodRequest("service2-endpoint", "message?message="+event.getData().getInput())
                .setHttpExtension(HttpExtension.GET);

        TypeRef<JsonNode> typeRef = new TypeRef<JsonNode>() {};
        return daprClient.invokeMethod(invokeMethodRequest, typeRef)
                .doOnSuccess(response -> log.info("process success response {}", response))
                .doOnError(e -> log.error("process failure error ", e));

    }

}
