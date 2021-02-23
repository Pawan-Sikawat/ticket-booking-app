package com.ciq.application.request;

public class AddCinemaMovieMappingRequest{
    private Integer cinemaId;
    private Integer movieId;

    public Integer getCinemaId()
    {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId)
    {
        this.cinemaId = cinemaId;
    }

    public Integer getMovieId()
    {
        return movieId;
    }

    public void setMovieId(Integer movieId)
    {
        this.movieId = movieId;
    }
}