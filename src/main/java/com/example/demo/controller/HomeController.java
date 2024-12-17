package com.example.demo.controller;

//
//import com.example.demo.dto.PubSubOptions;
//import com.example.demo.service.KafkaService;
//import com.hdfcbank.il.core.config.ILCoreConfig;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;


//@Slf4j
@RestController
@RequestMapping("/graalvm")
public class HomeController {

//    @Autowired
//    KafkaService kafkaService;

    @GetMapping("")
    public String home(){
        return "Hello ! Native";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloTo(@PathVariable String name) {
        return "Hello, " + name + "!"+ "welcome to graalvm";
    }

//    @Autowired
//    private ILCoreConfig iLCoreConfig;
//
//    @Autowired
//    private KafkaPubSubService kafkaPubSubService;
//
//    @GetMapping("/kafka")
//    public void log(Map<String, String> auditJsonMap) {
//        try {
//            var topicName = getTopicName(iLCoreConfig.getTopicName());
//            log.debug("Publishing event in Kafka with pubsubTopic as {} ", topicName);
//            log.debug("AsyncILAuditLoggingService ... auditJsonMap...{}",auditJsonMap);
//            Map<String, String> metadata = Map.of(
//                    TOPIC_PARTITIONING_KEY,
//                    auditJsonMap.get(TXN_ID));
//
//            PubSubOptions pubsubOptions= PubSubOptions.builder()
//                    .pubsubName(iLCoreConfig.getEventPubSubName())
//                    .requestData(auditJsonMap)
//                    .metadata(metadata)
//                    .topic(topicName)
//                    .build();
//
//            CompletableFuture.runAsync(() -> {
//                kafkaPubSubService.publishMessage(pubsubOptions);
//                log.debug("Successfully Published event in Kafka with pubsubTopic as {} ", topicName);
//            });
//
//
//        } catch (Exception e) {
//            ilLogErrorMessage(e, "Error storing audit log.");
//        }
//    }
//    private String getTopicName(String topicName) {
//        return StringUtils.isNotBlank(iLCoreConfig.getTopicPrefix()) ? iLCoreConfig.getTopicPrefix() + topicName : topicName;
//    }

//    @PostMapping("/publishDataToKafka")
//    public ResponseEntity<String> publishDataToKafka(@RequestBody PubSubOptions pubSubOptions) throws Exception {
//        try {
//
////            Map<String, Object> data = (Map<String, Object>) payload.get("data");
//            String ret=kafkaService.publishdataToKafka(pubSubOptions);
//            return ResponseEntity.ok("Publish Data Successfully to Kafka Topic");
//        }catch(Exception e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }



}
