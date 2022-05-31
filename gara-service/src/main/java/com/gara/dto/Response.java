package com.gara.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Response {

    private Integer code;
    private String message;

    public Response() {
    }
}
