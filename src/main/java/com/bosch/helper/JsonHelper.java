package com.bosch.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Anant on 31-05-2017.
 */
public class JsonHelper {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getInstance(String jsonString, Class<T> type) {
        try {
            return objectMapper.readValue(jsonString, type);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> String getJsonString(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Boolean compareJson(String jsonOne, String jsonTwo) {
        try {
            Map<String, Object> objectOne = (Map<String, Object>) objectMapper.readValue(jsonOne, Map.class);
            Map<String, Object> objectTwo = (Map<String, Object>) objectMapper.readValue(jsonTwo, Map.class);

            return objectOne.equals(objectTwo);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
