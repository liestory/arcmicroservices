package com.arcmicroservices.validator;

import com.arcmicroservices.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


/**
 * проверка карточки юзера с контроллера
 *
 * @author Asus 02.11.2023
 */
@Component
@Slf4j
public class UserDtoValidator {

    private MessageSource messageSource;

    public UserDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(UserDto userDto) {
        if (userDto.getUsername().isEmpty()) {
            log.error("Логин пустой");
            throw new NullPointerException("Логин пустой");
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            log.error("Пароли не совпадают");
            throw new RuntimeException("Пароли не совпадают");
        }
    }
}
