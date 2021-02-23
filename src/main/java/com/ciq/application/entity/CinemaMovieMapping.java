package com.ciq.application.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_movie_mapping")
public class CinemaMovieMapping {
    private Integer id;
    private Cinema cinema;
    private Movie movie;
    private Set<Integer> bookedSeats = new HashSet<Integer>();

    @Id
	@Column(name = "id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

    @Column(name = "hall")
    public Cinema getCinema()
    {
        return cinema;
    }

    public void setCinema (Cinema cinema)
    {
        this.cinema = cinema;
    }

    @Column(name = "movie")
    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    @Column(name = "booked_seats")
    public Set<Integer> getBookedSeats()
    {
        return bookedSeats;
    }

    public void setBookedSeats(Set<Integer> bookedSeats)
    {
        this.bookedSeats = bookedSeats;
    }
}
