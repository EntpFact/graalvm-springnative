package com.example.demo.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class InvokeMethodDto implements Serializable {

    private String appId;
    private JsonNode data;
    private String method;
    private Map<String,String> metadata;
}
