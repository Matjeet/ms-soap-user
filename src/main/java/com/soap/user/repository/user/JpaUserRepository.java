package com.soap.user.repository.user;

import com.soap.user.entity.UserEntity;
import com.soap.user.generated.User;
import com.soap.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.soap.user.mapper.UserMapper.convertToEntity;
import static com.soap.user.mapper.UserMapper.convertToUser;

@Repository
@Primary
public class JpaUserRepository implements IUserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
            .map(UserMapper::convertToUser)
            .toList();
    }

    @Override
    public Optional<User> findById(int id) {
        return userJpaRepository.findById(id)
            .map(UserMapper::convertToUser);
    }

    @Override
    public User saveUser(User user, Integer countryId) {
        UserEntity userEntity = convertToEntity(user);
        userEntity.getCountry().setId(countryId);
        return convertToUser(userJpaRepository.save(userEntity));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserMapper::convertToUser);
    }

    @Override
    public Optional<User> findByCellphone(String cellphone) {
        return userJpaRepository.findByCellphone(cellphone).map(UserMapper::convertToUser);
    }

    @Override
    public Optional<User> findByIdentityNumber(String identityNumber) {
        return userJpaRepository.findByIdentityNumber(identityNumber).map(UserMapper::convertToUser);
    }


}