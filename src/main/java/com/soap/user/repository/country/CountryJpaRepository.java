package com.soap.user.repository.country;

import com.soap.user.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryJpaRepository extends JpaRepository<CountryEntity, Integer> {

    CountryEntity findByName(String name);
}
