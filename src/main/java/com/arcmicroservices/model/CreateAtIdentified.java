package com.arcmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * абстрактный метод для проставления меток создания/обновления.
 *
 * @author Asus 02.11.2023
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class CreateAtIdentified {

    /**
     * время создание
     */
    LocalDateTime createdAt;

    /**
     * время обновление
     */
    LocalDateTime updatedAt;
}
