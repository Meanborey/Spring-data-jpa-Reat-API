package com.example.spring_data_jpa.user.web;

public record CreateUserDto( String name,
                             String sex,
                             String billingCity,
                             String email,
                             long password) {
}
