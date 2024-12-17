//package com.example.demo.service;
////
////import com.hdfcbank.messageconnect.config.PubSubOptions;
////import com.hdfcbank.messageconnect.dapr.producer.DaprProducer;
////import lombok.extern.slf4j.Slf4j;
//import com.example.demo.dto.PubSubOptions;
////import com.example.demo.producer.DaprProducer;
//import io.dapr.client.DaprClient;
//import io.dapr.client.DaprClientBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
////
////@Slf4j
//@Service
//@ComponentScan(basePackages = { "com.hdfcbank" })
//public class KafkaService {
//
//    @Value("${graalvm.dapr.topicname}")
//    private String topicName;
//
//    @Value("${graalvm.dapr.pubsubname}")
//    private String pubsubName;
//
////    @Value("${file.uploader.storage.provider}")
////    private String storageProviderName;
//
////    @Autowired
////    private DaprProducer daprProducer;
//
////    public void pushFileMetadata(Map<String,String> data) throws Exception{
////
//////        log.error("pushFileMetadata is getting call");
////
//////        Map<String,String> bucketMetaData=new HashMap<>();
//////        String fileSize = String.valueOf(exchange.getIn().getHeader("CamelGoogleCloudStorageContentLength", Long.class));
////
//////        String bucketName= exchange.getIn().getHeader("CamelGoogleCloudStorageBucketName", String.class);
//////
//////        String filePath= exchange.getIn().getHeader("CamelGoogleCloudStorageObjectName", String.class);
//////        String objectName = exchange.getIn().getHeader("CamelFileName", String.class);
//////        bucketMetaData.put("storageProvider",storageProviderName);
//////        bucketMetaData.put("fileDirectory",filePath);
//////        bucketMetaData.put("fileName",objectName);
//////        bucketMetaData.put("bucketName",bucketName);
//////        bucketMetaData.put("fileSize",fileSize);
////        publishDataToKafka(data, this.daprProducer);
////
////    }
//
//    public String publishdataToKafka(PubSubOptions pubSubOptions) {
////        var pubsubOptions= PubSubOptions.builder()
////                .pubsubName(pubsubName)
////                .requestData(data)
////                .metadata(null)
////                .topic(topicName)
////                .build();
////
////        daprProducer.invokeDaprPublishEvent(pubsubOptions).subscribe((resp) -> {
//////            log.error("Pubsub Mono Complete");
////        });
////    }
////
////    public void publishFileMetadataToKafk(Map<String,String> data){
////
////        publishDataToKafka(data, this.daprProducer);
////    }
//
//      try (DaprClient daprClient = new DaprClientBuilder().build()) {
//        daprClient.publishEvent(
//                pubSubOptions.getPubsubName(),
//                pubSubOptions.getTopic(),
//                pubSubOptions.getRequestData(),
//                pubSubOptions.getMetadata()
//        ).block();
//
//        return "Message published to topic: " + pubSubOptions.getTopic();
//    } catch (Exception e) {
//        e.printStackTrace();
//        return "Error: " + e.getMessage();
//    }
//}
//}
