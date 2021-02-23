package com.ciq.application.respository;

import java.util.List;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaMovieMapping;
import com.ciq.application.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaMovieMappingRepository extends JpaRepository<CinemaMovieMapping,Integer>{
    List<CinemaMovieMapping> findAllByCinema(Cinema cinema);
    List<CinemaMovieMapping> findAllByMovie(Movie movie); 
}
