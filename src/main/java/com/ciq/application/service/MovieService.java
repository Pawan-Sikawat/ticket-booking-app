package com.ciq.application.service;

import com.ciq.application.entity.Movie;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.respository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public BaseResponse saveMovie(Movie movie)
    {
        BaseResponse response = new BaseResponse();
        movieRepository.save(movie);
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("Movie Added Successfully");
        return response;
    }

    public Movie getMovieById(Integer id)
    {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovieByName(String name)
    {
        return movieRepository.findByName(name);
    }
}
