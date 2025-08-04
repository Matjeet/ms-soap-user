package com.soap.user.repository;

import com.soap.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
}