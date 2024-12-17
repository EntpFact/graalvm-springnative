package com.example.demo.controller;

import com.example.demo.config.PubSubOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final RestTemplate restTemplate;

    public KafkaController() {
        this.restTemplate = new RestTemplate();
    }

//    @PostMapping("/publish")
//    public ResponseEntity<String> publishMessage(@RequestBody PubSubOptions pubSubOptions) {
//        try {
//            String daprUrl = String.format("http://localhost:3500/v1.0/publish/%s/%s",
//                    pubSubOptions.getPubsubName(),
//                    pubSubOptions.getTopic());
//
//            Map<String, Object> body = new HashMap<>();
//            body.put("data", pubSubOptions.getRequestData());
//            body.put("metadata", pubSubOptions.getMetadata());
//
//            ResponseEntity<String> response = restTemplate.postForEntity(daprUrl, body, String.class);
//
//            if (response.getStatusCode().is2xxSuccessful()) {
//                return ResponseEntity.ok("Message published successfully.");
//            } else {
//                return ResponseEntity.status(response.getStatusCode())
//                        .body("Failed to publish message: " + response.getBody());
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error publishing message: " + e.getMessage());
//        }
//    }


//        private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

        @PostMapping("/publish")
        public ResponseEntity<String> publishMessage(@RequestBody PubSubOptions pubSubOptions) {
            log.info("Publishing message to Dapr...");



            String daprUrl = String.format("http://localhost:9092/v1.0/publish/%s/%s",  // for jar file
                    pubSubOptions.getPubsubName(),
                    pubSubOptions.getTopic());

           /* String daprUrl = String.format("http://host.docker.internal:3500/v1.0/publish/%s/%s", // for docker image
                    pubSubOptions.getPubsubName(),
                    pubSubOptions.getTopic());
*/

            Map<String, Object> body = new HashMap<>();
            body.put("data", pubSubOptions.getData());
            body.put("metadata", pubSubOptions.getMetadata());



            log.info("Dapr URL: {}", daprUrl);
            log.info("Message Data: {}", pubSubOptions.getData());

            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("dapr-app-id", "graalvm-kafkaapp");

                HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

                ResponseEntity<String> response = restTemplate.exchange(daprUrl, HttpMethod.POST, entity, String.class);

                log.info("Dapr response status: {}", response.getStatusCode());

                log.info("Dapr response: {}", response.getBody());


                return ResponseEntity.ok("Message published: " + response.getBody());
            } catch (HttpClientErrorException | HttpServerErrorException e) {
                log.error("Error publishing message to Dapr: HTTP Status: {}, Response: {}", e.getStatusCode(), e.getResponseBodyAsString());
                return ResponseEntity.status(e.getStatusCode()).body("Error publishing message: " + e.getMessage());
            } catch (Exception e) {
                log.error("Error publishing message to Dapr: {}", e.getMessage(), e);

                return ResponseEntity.status(500).body("Error publishing message: " + e.getMessage());
            }
        }
}

