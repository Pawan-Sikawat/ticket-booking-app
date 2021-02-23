package com.ciq.application.controller;

import java.util.List;
import java.util.Set;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaMovieMapping;
import com.ciq.application.entity.Movie;
import com.ciq.application.request.AddCinemaMovieMappingRequest;
import com.ciq.application.request.BookSeatsRequest;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.CinemaMovieMappingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaMovieMappingController {
    @Autowired
    private CinemaMovieMappingService cinemaMovieMappingService;

    @ResponseBody
    @PostMapping("/addCMMap")
    public BaseResponse addCinemaMovieMapping(@RequestBody AddCinemaMovieMappingRequest request)
    {
        return cinemaMovieMappingService.saveCinemaMovieMapping(request);
    }

    @ResponseBody
    @GetMapping("/getCMMapById/{id}")
    public CinemaMovieMapping getCinemaMovieMappingById(@PathVariable Integer id)
    {
        return cinemaMovieMappingService.getMappingById(id);
    }

    @ResponseBody
    @GetMapping("/getCMMapsByCinema")
    public List<CinemaMovieMapping> getCinemaMovieMappingsByCinema(@RequestBody Cinema cinema)
    {
        return cinemaMovieMappingService.getMappingsByCinema(cinema);
    }

    @ResponseBody
    @GetMapping("/getCMMapsByMovie")
    public List<CinemaMovieMapping> getCinemaMovieMappingsByMovie(@RequestBody Movie movie)
    {
        return cinemaMovieMappingService.getMappingsByMovie(movie);
    }

    @ResponseBody
    @GetMapping("/getBookedSeats/{id}")
    public Set<Integer> getBookedSeatsById(@PathVariable Integer id)
    {
        return cinemaMovieMappingService.getBookedSeatsById(id);
    }

    @ResponseBody
    @PostMapping("/bookNewSeats")
    public BaseResponse bookNewSeatsById(@RequestBody BookSeatsRequest request)
    {
        return cinemaMovieMappingService.bookSeatsById(request);
    }
}
