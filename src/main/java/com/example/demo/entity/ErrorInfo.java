package com.example.demo.entity;

import lombok.Data;

import java.util.PrimitiveIterator;

@Data
public class ErrorInfo<T> {
    private String message;
    private Integer code;
    private String url;
    private T Data;
}
