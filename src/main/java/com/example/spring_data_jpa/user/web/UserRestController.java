package com.example.spring_data_jpa.user.web;

import com.example.spring_data_jpa.base.BaseApi;
import com.example.spring_data_jpa.user.User;
import com.example.spring_data_jpa.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public BaseApi<?>addNewUser(@RequestBody CreateUserDto createUserDto){
        User user = userService.addNewUser(createUserDto);

        return BaseApi.builder()
                .message("Post User Success.......")
                .data(user)
                .code(HttpStatus.OK.value())
                .timeStamp(LocalDateTime.now())
                .status(Boolean.TRUE)
                .build();
    }

    @GetMapping("/all")
    public BaseApi<List<User>>findAllUser(){
        var user = userService.findAllUsers();
        return BaseApi.<List<User>>builder()
                .message("Get Success.................")
                .data(user)
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @GetMapping("/{id}")
    public BaseApi<User>findUserById(@PathVariable("id") long id){
        try {
            Optional<User> userOptional = Optional.ofNullable(userService.findUserById(id));
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                return BaseApi.<User>builder()
                        .message("Get User By Id Success")
                        .data(user)
                        .status(true)
                        .timeStamp(LocalDateTime.now())
                        .code(HttpStatus.OK.value())
                        .build();
            }
            else {
                return BaseApi.<User>builder()
                        .message("User not found")
                        .data(null)
                        .status(false)
                        .timeStamp(LocalDateTime.now())
                        .code(HttpStatus.NOT_FOUND.value())
                        .build();
            }
        } catch (Exception e) {
            // Log the exception
            return BaseApi.<User>builder()
                    .message("User not found")
                    .data(null)
                    .status(false)
                    .timeStamp(LocalDateTime.now())
                    .code(HttpStatus.NOT_FOUND.value())
                    .build();
        }

    }

    @DeleteMapping("/{id}")
    public BaseApi<?>deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return BaseApi.builder()
                .message("Delete User Success")
                .data("User with id "+id+" deleted")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

}
