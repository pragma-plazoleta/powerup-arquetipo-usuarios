package com.pragma.powerup_user.infrastructure.out.jpa.repository;

import com.pragma.powerup_user.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByCorreo(String userName);

}
