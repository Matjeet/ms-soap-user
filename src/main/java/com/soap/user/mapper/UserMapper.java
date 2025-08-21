package com.soap.user.mapper;

import com.soap.user.entity.CountryEntity;
import com.soap.user.entity.UserEntity;
import com.soap.user.generated.User;
import com.soap.user.generated.UserCreation;

import static com.soap.user.util.Constants.INITIAL_BALANCE;

public class UserMapper {

    private UserMapper() {
    }

    public static User convertToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setCellphone(userEntity.getCellphone());
        user.setIdentityType(userEntity.getIdentityType());
        user.setIdentityNumber(userEntity.getIdentityNumber());
        user.setBalance(userEntity.getBalance());
        user.setCountry(userEntity.getCountry().getName());
        return user;
    }

    public static UserEntity convertToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        userEntity.setCellphone(user.getCellphone());
        userEntity.setIdentityType(user.getIdentityType());
        userEntity.setIdentityNumber(user.getIdentityNumber());
        userEntity.setBalance(INITIAL_BALANCE);
        userEntity.setCountry(new CountryEntity());
        return userEntity;
    }

    public static User convertToUser(UserCreation userCreation){
        User user = new User();
        user.setEmail(userCreation.getEmail());
        user.setName(userCreation.getName());
        user.setLastName(userCreation.getLastName());
        user.setCellphone(userCreation.getCellphone());
        user.setIdentityType(userCreation.getIdentityType());
        user.setIdentityNumber(userCreation.getIdentityNumber());
        return user;
    }
}
