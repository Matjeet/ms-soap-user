package com.soap.user.service;

import com.soap.user.generated.RechargeBalance;
import com.soap.user.generated.User;
import com.soap.user.generated.UserCreation;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    String saveUser(UserCreation user);
    String rechargeBalance(RechargeBalance balance);
}