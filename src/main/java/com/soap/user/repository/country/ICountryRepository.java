package com.soap.user.repository.country;

import com.soap.user.entity.CountryEntity;

public interface ICountryRepository {
    CountryEntity findByName(String name);
}