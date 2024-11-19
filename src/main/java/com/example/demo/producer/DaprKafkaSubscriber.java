//package com.example.demo.producer;
//
//import io.dapr.client.DaprClient;
//import io.dapr.client.DaprClientBuilder;
//
//public class DaprKafkaSubscriber {
//
//    public void subscribeToKafka(String pubsubName, String topic) {
//        try (DaprClient daprClient = new DaprClientBuilder().build()) {
//                daprClient.subscribe(pubsubName, topic).subscribe(event -> {
//                System.out.println("Received message: " + event.getData());
//                // Process the event
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
