package com.ciq.application.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaMovieMapping;
import com.ciq.application.entity.Movie;
import com.ciq.application.request.AddCinemaMovieMappingRequest;
import com.ciq.application.request.BookSeatsRequest;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.respository.CinemaMovieMappingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaMovieMappingService{
    @Autowired
    private CinemaMovieMappingRepository cinemaMovieMappingRepository;

    public BaseResponse saveCinemaMovieMapping(AddCinemaMovieMappingRequest request)
    {
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = cinemaService.getCinemaById(request.getCinemaId());
        MovieService movieService = new MovieService();
        Movie movie = movieService.getMovieById(request.getMovieId());

        CinemaMovieMapping newMap = new CinemaMovieMapping();
        newMap.setCinema(cinema);
        newMap.setMovie(movie);
        cinemaMovieMappingRepository.save(newMap);

        BaseResponse response = new BaseResponse();
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("Mapping saved successfully");

        return response;
    }

    public CinemaMovieMapping getMappingById(Integer id)
    {
        return cinemaMovieMappingRepository.findById(id).orElse(null);
    }

    public List<CinemaMovieMapping> getMappingsByCinema(Cinema cinema)
    {
        return cinemaMovieMappingRepository.findAllByCinema(cinema);
    }

    public List<CinemaMovieMapping> getMappingsByMovie(Movie movie)
    {
        return cinemaMovieMappingRepository.findAllByMovie(movie);
    }

    public Set<Integer> getBookedSeatsById(Integer id)
    {
        CinemaMovieMapping ourMap = getMappingById(id);
        return ourMap.getBookedSeats();
    }

    public BaseResponse bookSeatsById(BookSeatsRequest request)
    {
        CinemaMovieMapping ourMap = getMappingById(request.getId());
        Set<Integer> newSeats = ourMap.getBookedSeats();
        newSeats.addAll(request.getBookSeats());
        ourMap.setBookedSeats(newSeats);

        cinemaMovieMappingRepository.save(ourMap);

        BaseResponse response = new BaseResponse();
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("Booked Seats Successfully");
        
        return response;
    }

    public Set<Movie> getMoviesByCinema(Cinema cinema)
    {
        List<CinemaMovieMapping> allMaps = getMappingsByCinema(cinema);
        Set<Movie> allMovies = new HashSet<Movie>();
        for(int i=0; i<allMaps.size(); i++)
        {
            allMovies.add(allMaps.get(i).getMovie());
        }
        return allMovies;
    }
}
