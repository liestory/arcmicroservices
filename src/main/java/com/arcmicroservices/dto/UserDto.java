package com.arcmicroservices.dto;

import com.arcmicroservices.model.RoleGlobal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.UUID;

/**
 * объекты для игр получаемые с контролеров
 *
 * @author Asus 02.11.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "объект .pth")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8443900228900286833L;

    /**
     * id юзера
     */
    @ApiModelProperty(value = "id юзера", required = true)
    private UUID id;

    /**
     * логин юзера
     */
    @ApiModelProperty(value = "логин юзера", required = true)
    private String username;

    /**
     * пароль юзера
     */
    @ApiModelProperty(value = "пароль юзера", required = true)
    private String password;

    /**
     * повтор пароля
     */
    @ApiModelProperty(value = "повтор пароля", required = true)
    private String repeatPassword;

    /**
     * почта юзера
     */
    @ApiModelProperty(value = "почта юзера", required = true)
    private String email;

    /**
     * глобальная роль в системе
     */
    @ApiModelProperty(value = "Роль юзера", required = true)
    private RoleGlobal roleGlobal;

}
