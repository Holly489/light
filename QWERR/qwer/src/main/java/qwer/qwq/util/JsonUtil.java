package qwer.qwq.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToBean(String json,Class<T> cls){
        try {
            return objectMapper.readValue(json,cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String convertBeanToJson(T t){
        try {
            return objectMapper.writeValueAsString(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

