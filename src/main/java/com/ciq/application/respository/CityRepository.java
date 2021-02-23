package com.ciq.application.respository;

import com.ciq.application.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer>{
    City findByName(String name);
}
