package com.example.demo.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class InvokeBindingDTO implements Serializable {

    private String bindingName;
    private JsonNode data;
    private String operation;
    private Map<String,String> metadata;
}
