package com.ciq.application.controller;

import java.util.List;
import java.util.Set;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaCityMapping;
import com.ciq.application.entity.City;
import com.ciq.application.entity.Movie;
import com.ciq.application.request.AddCinemaCityMappingRequest;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.CinemaCityMappingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaCityMappingController {
    @Autowired
    private CinemaCityMappingService cinemaCityMappingService;

    @ResponseBody
    @PostMapping("/addCCMap")
    public BaseResponse addCinemaCityMapping(@RequestBody AddCinemaCityMappingRequest request)
    {
        return cinemaCityMappingService.saveCinemaCityMapping(request);
    }

    @ResponseBody
    @GetMapping("/getCCMapById/{id}")
    public CinemaCityMapping getCinemaCityMappingById(@PathVariable Integer id)
    {
        return cinemaCityMappingService.getMappingById(id);
    }

    @ResponseBody
    @GetMapping("/getCCMapByCinema")
    public CinemaCityMapping getCinemaCityMappingByCinema(@RequestBody Cinema cinema)
    {
        return cinemaCityMappingService.getMappingByCinema(cinema);
    }

    @ResponseBody
    @GetMapping("/getCCMapByCity")
    public List<CinemaCityMapping> getCinemaCityMappingByCity(@RequestBody City city)
    {
        return cinemaCityMappingService.getMappingsByCity(city);
    }

    @ResponseBody
    @GetMapping("/getMoviesByCity")
    public Set<Movie> getAllMoviesByCity(@RequestBody City city)
    {
        return cinemaCityMappingService.getAllMoviesByCity(city);
    }
}
