package com.soap.user.repository;

import com.soap.user.generated.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
}