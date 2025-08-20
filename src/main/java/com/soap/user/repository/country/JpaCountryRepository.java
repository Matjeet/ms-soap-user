package com.soap.user.repository.country;

import com.soap.user.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCountryRepository implements ICountryRepository{

    @Autowired
    private CountryJpaRepository countryRepository;

    @Override
    public CountryEntity findByName(String name) {
        return countryRepository.findByName(name);
    }
}
