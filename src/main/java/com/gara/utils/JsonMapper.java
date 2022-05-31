package com.gara.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


@Slf4j
public class JsonMapper {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <O> String write(O o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <O> O read(String string, Class<O> clazz) {
        try {
            return MAPPER.readValue(string, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <O> O read(String string, TypeReference<O> typeReference) {
        try {
            return MAPPER.readValue(string, typeReference);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <O> O read(Reader reader, Class<O> clazz) {
        try {
            return MAPPER.readValue(reader, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <O> byte[] writeAsBytes(O o) {
        try {
            return MAPPER.writeValueAsBytes(o);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new byte[0];
        }
    }

    public static <O> O read(byte[] bytes, TypeReference<O> typeReference) {
        try {
            return MAPPER.readValue(bytes, typeReference);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <O> O readValue(InputStream inputStream, Class<O> clazz) {
        try {
            return MAPPER.readValue(inputStream, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
