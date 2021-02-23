package com.ciq.application.service;

import com.ciq.application.entity.City;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.respository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public BaseResponse saveCity(City city)
    {
        BaseResponse response = new BaseResponse();
        cityRepository.save(city);
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("City Added Successfully");
        return response;
    }

    public City getCityById(Integer id)
    {
        return cityRepository.findById(id).orElse(null);
    }

    public City getCityByName(String name)
    {
        return cityRepository.findByName(name);
    }
}
