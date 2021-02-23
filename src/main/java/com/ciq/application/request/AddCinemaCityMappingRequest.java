package com.ciq.application.request;

public class AddCinemaCityMappingRequest {
    private Integer cinemaId;
    private Integer cityId;

    public Integer getCinemaId()
    {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId)
    {
        this.cinemaId = cinemaId;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }
}
