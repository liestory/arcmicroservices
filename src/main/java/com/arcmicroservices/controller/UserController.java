package com.arcmicroservices.controller;

import com.arcmicroservices.dto.ResponseError;
import com.arcmicroservices.dto.UserDto;
import com.arcmicroservices.service.UserService;
import com.arcmicroservices.validator.UserDtoValidator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Asus 02.11.2023
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    private UserService userService;
    private UserDtoValidator userDtoValidator;

    public UserController(UserService userService, UserDtoValidator userDtoValidator) {
        this.userService = userService;
        this.userDtoValidator = userDtoValidator;
    }

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    @ApiOperation(value = "создание юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder) {
        log.debug("create with {} - start ", userDto);
        userDtoValidator.validate(userDto);
        var result = userService.regUser(userDto);
        var uri = componentsBuilder.path("/api/v1/user/" + result.getId()).buildAndExpand(result).toUri();
        log.debug("create with {} - end", result);
        return ResponseEntity.created(uri).body(result);
    }

    //GET
    @GetMapping("{id}")
    @ApiOperation(value = "получение юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    public ResponseEntity<UserDto> getUser(@PathVariable("id") UUID id) {
        log.debug("get with {} - start ", id);
        var result = userService.getUser(id);
        log.debug("get end with {}, with result {}", id, result);
        return ResponseEntity.ok().body(result);
    }

    //UPDATE
    @PutMapping("{id}")
    @ApiOperation(value = "обновление юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    public ResponseEntity updateUser(@RequestBody UserDto userDto, @PathVariable("id") UUID id) {
        log.debug("update with {} - start ", userDto);
        if (!Objects.equals(id, userDto.getId())) {
            throw new IllegalArgumentException("id=" + userDto.getId() + ": expected same as " + id);
        }
        userDtoValidator.validate(userDto);
        var result = userService.updateUser(userDto);
        log.debug("update with {} - end", result);
        return ResponseEntity.ok().body(result);
    }

    //delete
    @DeleteMapping("{id}")
    @ApiOperation(value = "удаление юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })

    public ResponseEntity deleteUser(@PathVariable("id") UUID id) {
        log.debug("delete with {} - start ", id);
        userService.deleteUser(id);
        log.debug("delete end with {}", id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
