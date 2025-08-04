package com.soap.user.service;

import com.soap.user.generated.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
}