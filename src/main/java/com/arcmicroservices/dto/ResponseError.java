package com.arcmicroservices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * карточки ошибки.
 *
 * @author Asus 02.11.2023
 */
@Getter
@Setter
@ApiModel(description = "карточки ошибки.")
public class ResponseError {
    /**
     * id ошибки
     */
    @ApiModelProperty(value = "id ошибки", required = true)
    private UUID id;

    /**
     * сообщение об ошибке
     */
    @ApiModelProperty(value = "сообщение об ошибке", required = true)
    private String message;

    /**
     * код ошибки
     */
    @ApiModelProperty(value = "код ошибки", required = true)
    private String codeError;

    /**
     * имя моей системы
     */
    @ApiModelProperty(value = "имя моей системы", required = true)
    private String systemName;

    public ResponseError(UUID id, String message, String codeError, String systemId) {
        this.id = id;
        this.message = message;
        this.codeError = codeError;
        this.systemName = systemId;
    }
}
