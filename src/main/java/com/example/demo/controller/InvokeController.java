package com.example.demo.controller;

import com.example.demo.dto.InvokeBindingDTO;
import com.fasterxml.jackson.databind.JsonNode;
import io.dapr.client.DaprClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("invoke")
@Slf4j
public class InvokeController {

    @Autowired
    private DaprClient daprClient;

    /**
     * Generic implementation to verify invoke binding
     * @param invokeBindingDTO
     * @return
     */
    @PostMapping("invoke")
    public Mono<JsonNode> invokeBinding(@RequestBody InvokeBindingDTO invokeBindingDTO) {

        log.info("invoke {}", invokeBindingDTO);
        return daprClient.invokeBinding(invokeBindingDTO.getBindingName(), invokeBindingDTO.getOperation(), invokeBindingDTO.getData(), invokeBindingDTO.getMetadata(), JsonNode.class)
                .doOnSuccess(response -> log.info("invoke success response {}", response))
                .doOnError(e -> log.error("invoke failure", e));

    }
}
