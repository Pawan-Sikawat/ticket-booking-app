package com.ciq.application.respository;

import com.ciq.application.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
    Movie findByName(String name);
}
