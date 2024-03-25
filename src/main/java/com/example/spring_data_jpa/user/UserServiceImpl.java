package com.example.spring_data_jpa.user;

import com.example.spring_data_jpa.user.web.CreateUserDto;
import lombok.RequiredArgsConstructor;;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User addNewUser(CreateUserDto createUserDto) {
        User user =  UserMapper.INSTANCE.toEntity(createUserDto);

        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long Id) {
        return userRepository.findById(Id).orElseThrow();
    }

    @Override
    public void deleteUserById(long Id) {
        userRepository.deleteById(Id);
    }


}
