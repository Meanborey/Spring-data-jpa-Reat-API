package com.example.spring_data_jpa.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorApi<T>(
        Boolean status,
        Integer code,
        String messages,
        LocalDateTime timeStamp,
        T errors
) {
}