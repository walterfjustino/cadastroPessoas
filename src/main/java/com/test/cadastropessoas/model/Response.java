package com.test.cadastropessoas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response <T> extends RepresentationModel<Response<T>> {

    private int statusCode;
    private T data;
    private Long timestamp;

    public Response(){
        this.timestamp = System.currentTimeMillis();
    }
}
