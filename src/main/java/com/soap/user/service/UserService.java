package com.soap.user.service;

import com.soap.user.entity.CountryEntity;
import com.soap.user.exception.IncorrectCellphoneException;
import com.soap.user.exception.IncorrectEmailException;
import com.soap.user.exception.UserAlreadyExistException;
import com.soap.user.generated.User;
import com.soap.user.generated.UserCreation;
import com.soap.user.repository.country.ICountryRepository;
import com.soap.user.repository.user.IUserRepository;
import com.soap.user.util.Countries;
import jakarta.jws.HandlerChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.soap.user.mapper.UserMapper.convertToUser;
import static com.soap.user.util.Messages.*;
import static com.soap.user.util.Validations.*;

@Service
@HandlerChain(file = "handle-chain.xml")
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final ICountryRepository countryRepository;

    @Autowired
    public UserService(IUserRepository userRepository,
                       ICountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public String saveUser(UserCreation user) {

        isFieldsNotEmptyOrNull(user);

        if(!isValidEmail(user.getEmail())) throw new IncorrectEmailException(INCORRECT_EMAIL);

        if(!isValidCellPhone(user.getCellphone())) throw new IncorrectCellphoneException(INCORRECT_CELLPHONE);

        user.setCellphone(Countries.getCompleteCellphone(user.getCountry(), user.getCellphone()));

        if(validateUserInDB(user)) throw new UserAlreadyExistException(USER_ALREADY_EXIST);

        CountryEntity country = countryRepository.findByName(user.getCountry());

        userRepository.saveUser(convertToUser(user), country);

        return USER_CREATED_SUCCESS;
    }

    private boolean validateUserInDB(UserCreation user){
        return userRepository.findByEmail(user.getEmail()).isPresent() ||
                userRepository.findByCellphone(user.getCellphone()).isPresent() ||
                userRepository.findByIdentityNumber(user.getIdentityNumber()).isPresent();
    }
}