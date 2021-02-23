package com.ciq.application.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaCityMapping;
import com.ciq.application.entity.City;
import com.ciq.application.entity.Movie;
import com.ciq.application.request.AddCinemaCityMappingRequest;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.respository.CinemaCityMappingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaCityMappingService {
    @Autowired
    private CinemaCityMappingRepository cinemaCityMappingRepository;

    public BaseResponse saveCinemaCityMapping(AddCinemaCityMappingRequest request)
    {
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = cinemaService.getCinemaById(request.getCinemaId());
        CityService cityService = new CityService();
        City city = cityService.getCityById(request.getCityId());

        CinemaCityMapping newMap = new CinemaCityMapping();
        newMap.setCinema(cinema);
        newMap.setCity(city);
        cinemaCityMappingRepository.save(newMap);

        BaseResponse response = new BaseResponse();
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("Mapping added successfully");

        return response;
    }

    public CinemaCityMapping getMappingById(Integer id)
    {
        return cinemaCityMappingRepository.findById(id).orElse(null);
    }

    public CinemaCityMapping getMappingByCinema(Cinema cinema)
    {
        return cinemaCityMappingRepository.findByCinema(cinema);
    }

    public List<CinemaCityMapping> getMappingsByCity(City city)
    {
        return cinemaCityMappingRepository.findAllByCity(city);
    }

    public Set<Cinema> getAllCinemasByCity(City city)
    {
        List<CinemaCityMapping> allMaps = getMappingsByCity(city);
        Set<Cinema> allCinemas = new HashSet<Cinema>();
        for(int i=0; i<allMaps.size(); i++)
        {
            allCinemas.add(allMaps.get(i).getCinema());
        }
        return allCinemas;
    }

    public Set<Movie> getAllMoviesByCity(City city)
    {
        Set<Cinema> allCinemas = getAllCinemasByCity(city);
        Set<Movie> allMovies = new HashSet<Movie>();
        CinemaMovieMappingService cmMapService = new CinemaMovieMappingService();
        for(Cinema tempCinema : allCinemas)
        {
            allMovies.addAll(cmMapService.getMoviesByCinema(tempCinema));
        }
        return allMovies;
    }
}
