package com.soap.user.repository.user;

import com.soap.user.entity.CountryEntity;
import com.soap.user.generated.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
    User saveUser(User user, CountryEntity country);
    Optional<User> findByEmail(String email);
    Optional<User> findByCellphone(String cellphone);
    Optional<User> findByIdentityNumber(String identityNumber);
}