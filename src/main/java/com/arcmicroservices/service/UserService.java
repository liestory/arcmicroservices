package com.arcmicroservices.service;

import com.arcmicroservices.dto.UserDto;
import com.arcmicroservices.model.User;

import java.util.UUID;

/**
 * сервис по работе с юзерами
 *
 * @author Asus 02.11.2023
 */
public interface UserService {

    /**
     * регистрация пользователя
     *
     * @param userDto - карточка пользователя с формы регистрации
     * @return
     */
    UserDto regUser(UserDto userDto);

    /**
     * поиск пользователя
     *
     * @param id - id юзера в системе
     * @return - карточка юзера без паролей
     */
    UserDto getUser(UUID id);

    /**
     * обновление пользователя
     *
     * @param userDto - карточка юзера
     * @return - карточка юзера
     */

    UserDto updateUser(UserDto userDto);

    /**
     * удаление пользователя
     * полноценного удаления нет, просто проставляем признат выключенности
     *
     * @param id - id юзера в системе
     */

    void deleteUser(UUID id);

    /**
     * добавить пользователя
     *
     * @param user - карточка юзера
     */
    void addUser(User user);


}
