package com.ciq.application.controller;

import com.ciq.application.entity.Movie;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ResponseBody
    @PostMapping("/addMovie")
    public BaseResponse addMovie(@RequestBody Movie movie)
    {
        return movieService.saveMovie(movie);
    }

    @ResponseBody
    @GetMapping("/getMovieById/{id}")
    public Movie getMovieById(@PathVariable Integer id)
    {
        return movieService.getMovieById(id);
    }

    @ResponseBody
    @GetMapping("/getMovieByName/{name}")
    public Movie getMovieByName(@PathVariable String name)
    {
        return movieService.getMovieByName(name);
    }
}
