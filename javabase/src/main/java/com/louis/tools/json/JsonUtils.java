package com.louis.tools.json;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 *//*

package com.louis.tools.json;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

*/
/**
 * Json序列化/反序列化帮助类<br/>
 * 使用jackson实现
 *//*

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.findAndRegisterModules();
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return (T) objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> type) {
        try {
            return (T) objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object fromNestedGenericJson(String json, Class... types) {
        if (types.length < 2) {
            throw new IllegalArgumentException("type number can not be less than 2");
        }
        JavaType javaType = null;
        for (int i = types.length - 2; i >= 0; i--) {
            if (javaType == null) {
                javaType = objectMapper.getTypeFactory().constructParametricType(types[i], types[i + 1]);
            } else {
                javaType = objectMapper.getTypeFactory().constructParametricType(types[i], javaType);
            }
        }
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
