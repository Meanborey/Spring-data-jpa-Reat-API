package com.example.spring_data_jpa.user;

import com.example.spring_data_jpa.user.web.CreateUserDto;
import com.example.spring_data_jpa.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(CreateUserDto createUserDto);
    UserDto mapUserToUserDto(User user);

}
