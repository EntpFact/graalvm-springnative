package com.example.demo.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PubSubData implements Serializable {

    @Serial
    private static final long serialVersionUID = -5783681229647031331L;
    private String input;
}
