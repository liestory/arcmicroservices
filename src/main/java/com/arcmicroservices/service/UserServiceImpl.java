package com.arcmicroservices.service;

import com.arcmicroservices.dto.UserDto;
import com.arcmicroservices.model.User;
import com.arcmicroservices.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.UUID;


/**
 * @author Asus 02.11.2023
 */
@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword());
        userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public UserDto getUser(UUID id) {
        User user = userRepository.getOne(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.getOne(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return userDto;
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userRepository.save(user);
    }


}
