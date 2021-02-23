package com.ciq.application.service;

import com.ciq.application.entity.Cinema;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.respository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public BaseResponse saveCinema(Cinema cinema)
    {
        BaseResponse response = new BaseResponse();
        cinemaRepository.save(cinema);
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("Cinema Added Successfully");
        return response;
    }

    public Cinema getCinemaById(Integer id)
    {
        return cinemaRepository.findById(id).orElse(null);
    }

    public Cinema getCinemaByName(String name)
    {
        return cinemaRepository.findByName(name);
    }
}
