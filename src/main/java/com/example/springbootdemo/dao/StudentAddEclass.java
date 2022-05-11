package com.example.springbootdemo.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentAddEclass extends Student implements Serializable {
    String EClassName;

    public String toObj() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(this);
    }
}
