package com.soap.user.repository.user;

import com.soap.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByCellphone(String cellphone);
    Optional<UserEntity> findByIdentityNumber(String identityNumber);

}