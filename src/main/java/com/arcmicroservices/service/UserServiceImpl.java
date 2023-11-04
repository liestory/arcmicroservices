package com.arcmicroservices.service;

import com.arcmicroservices.dto.UserDto;
import com.arcmicroservices.model.User;
import com.arcmicroservices.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * @author Asus 02.11.2023
 */
@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final MapperFacade mapperFacade;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = mapperFacade.map(userDto, User.class);
        user.setId(randomUUID());
        user.setActiveUser(true);
        userRepository.save(user);
        userDto = mapperFacade.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto getUser(UUID id) {
        User user = userRepository.getOne(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRoleGlobal(user.getRoleGlobal());
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
        userRepository.getOne(id).setActiveUser(false);
    }

    @Override
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userRepository.save(user);
    }


}
