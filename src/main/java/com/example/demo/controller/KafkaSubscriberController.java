package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class KafkaSubscriberController {

    @PostMapping("/graalvm-topic")
    public ResponseEntity<Void> publishKafkaMessage(@RequestBody Map<String, Object> message) {
        System.out.println("Received message: " + message);
        return ResponseEntity.ok().build();
    }
}

