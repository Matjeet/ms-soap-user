package com.soap.user.repository;

import com.soap.user.generated.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements IUserRepository {

    private final List<User> users = Arrays.asList(
        createUser(1, "Juan Pérez", "juan.perez@email.com"),
        createUser(2, "María García", "maria.garcia@email.com"),
        createUser(3, "Carlos López", "carlos.lopez@email.com")
    );

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
    }

    private User createUser(int id, String name, String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}