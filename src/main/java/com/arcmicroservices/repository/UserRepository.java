package com.arcmicroservices.repository;

import com.arcmicroservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

/**
 * репозиторий для работы с базой user
 *
 * @author nemykin 03.11.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    Optional<User> findUserByUsername(String name);
}
