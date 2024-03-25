package com.example.spring_data_jpa.user;

import com.example.spring_data_jpa.user.web.CreateUserDto;
import com.example.spring_data_jpa.user.web.UserDto;
import org.mapstruct.ap.shaded.freemarker.ext.beans.CollectionModel;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User addNewUser(CreateUserDto createUserDto);

    List<User> findAllUsers();

    User findUserById(long Id);

    void deleteUserById(long Id);


}