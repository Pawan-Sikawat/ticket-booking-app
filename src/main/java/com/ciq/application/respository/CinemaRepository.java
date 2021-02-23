package com.ciq.application.respository;

import com.ciq.application.entity.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
    Cinema findByName(String name);
}
