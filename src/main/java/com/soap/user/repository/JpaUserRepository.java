package com.soap.user.repository;

import com.soap.user.entity.UserEntity;
import com.soap.user.generated.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class JpaUserRepository implements IUserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
            .map(this::convertToUser)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(int id) {
        return userJpaRepository.findById(id)
            .map(this::convertToUser);
    }

    private User convertToUser(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        return user;
    }
}