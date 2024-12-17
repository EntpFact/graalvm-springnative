package com.example.demo.config;

//import lombok.Builder;
//import lombok.Data;
//
//import java.util.Map;
//
//@Data
//@Builder
//public class PubSubOptions {
//        private String pubsubName;
//        private String topic;
//        private Object requestData;
//        private Map<String, String> metadata;
//}

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class PubSubOptions {
    private String pubsubName;
    private String topic;
    private PubSubData data;
    private Map<String, String> metadata;

/*
    // Getters and Setters
    public String getPubsubName() {
        return pubsubName;
    }

    public void setPubsubName(String pubsubName) {
        this.pubsubName = pubsubName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Object getRequestData() {
        return requestData;
    }

    public void setRequestData(Object requestData) {
        this.requestData = requestData;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
*/
}
