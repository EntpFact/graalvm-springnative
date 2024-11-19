package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final RestTemplate restTemplate;

    public KafkaController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody PubSubOptions pubSubOptions) {
        try {
            String daprUrl = String.format("http://localhost:3500/v1.0/publish/%s/%s",
                    pubSubOptions.getPubsubName(),
                    pubSubOptions.getTopic());

            Map<String, Object> body = new HashMap<>();
            body.put("data", pubSubOptions.getRequestData());
            body.put("metadata", pubSubOptions.getMetadata());

            ResponseEntity<String> response = restTemplate.postForEntity(daprUrl, body, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("Message published successfully.");
            } else {
                return ResponseEntity.status(response.getStatusCode())
                        .body("Failed to publish message: " + response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error publishing message: " + e.getMessage());
        }
    }
}
