package com.ciq.application.controller;

import com.ciq.application.entity.City;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @ResponseBody
    @PostMapping("/addCity")
    public BaseResponse addCity(@RequestBody City city)
    {
        return cityService.saveCity(city);
    }

    @ResponseBody
    @GetMapping("/getCityById/{id}")
    public City getCityById(@PathVariable Integer id)
    {
        return cityService.getCityById(id);
    }

    @ResponseBody
    @GetMapping("/getCityByName/{name}")
    public City getCityByName(@PathVariable String name)
    {
        return cityService.getCityByName(name);
    }
}
