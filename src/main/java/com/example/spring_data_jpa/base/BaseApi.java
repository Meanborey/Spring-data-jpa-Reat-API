package com.example.spring_data_jpa.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseApi<T>(
        String message,
        Integer code,
        Boolean status,
        LocalDateTime timeStamp,
        T data
) {
}
