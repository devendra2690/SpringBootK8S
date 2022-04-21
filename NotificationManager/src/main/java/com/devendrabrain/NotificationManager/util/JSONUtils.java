package com.devendrabrain.NotificationManager.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtils {

    @JsonCreator
    public static <T> T toObject(String json, Class<T> returnClass) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(json, returnClass);

    }
}
