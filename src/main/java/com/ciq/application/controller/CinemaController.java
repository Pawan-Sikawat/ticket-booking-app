package com.ciq.application.controller;

import com.ciq.application.entity.Cinema;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @ResponseBody
    @PostMapping("/addCinema")
    public BaseResponse addCinema(@RequestBody Cinema cinema)
    {
        return cinemaService.saveCinema(cinema);
    }

    @ResponseBody
    @GetMapping("/getCinemaById/{id}")
    public Cinema getCinemaById(@PathVariable Integer id)
    {
        return cinemaService.getCinemaById(id);
    }

    @ResponseBody
    @GetMapping("/getCinemaByName/{name}")
    public Cinema getCinemaByName(@PathVariable String name)
    {
        return cinemaService.getCinemaByName(name);
    }
}
